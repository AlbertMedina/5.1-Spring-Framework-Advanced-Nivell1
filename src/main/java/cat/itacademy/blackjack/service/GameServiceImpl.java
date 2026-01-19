package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.*;
import cat.itacademy.blackjack.exception.GameNotFoundException;
import cat.itacademy.blackjack.exception.InvalidGameActionException;
import cat.itacademy.blackjack.mapper.GameMapper;
import cat.itacademy.blackjack.model.Game;
import cat.itacademy.blackjack.model.GameAction;
import cat.itacademy.blackjack.model.GameState;
import cat.itacademy.blackjack.model.Player;
import cat.itacademy.blackjack.repository.GameRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GameServiceImpl implements GameService {

    private final PlayerService playerService;
    private final GameRepository gameRepository;

    public GameServiceImpl(PlayerService playerService, GameRepository gameRepository) {
        this.playerService = playerService;
        this.gameRepository = gameRepository;
    }

    @Override
    public Mono<GameDTO> createGame(CreateGameDTO createGameDTO) {
        Player player = playerService.getOrCreatePlayer(createGameDTO.playerName());
        return gameRepository.save(Game.newGame(player.getId()))
                .map(GameMapper::toDto);
    }

    @Override
    public Mono<GameDTO> getGameInfo(String id) {
        return gameRepository.findById(id)
                .switchIfEmpty(Mono.error(new GameNotFoundException(id)))
                .map(GameMapper::toDto);
    }

    @Override
    public Mono<GameDTO> playGame(String id, PlayGameDTO playGameDTO) {
        return gameRepository.findById(id)
                .switchIfEmpty(Mono.error(new GameNotFoundException(id)))
                .flatMap(g -> {
                    GameAction action = playGameDTO.action();

                    if (action == null) {
                        throw new InvalidGameActionException(null, "Unsupported game action");
                    }

                    switch (action) {
                        case HIT -> g.hit();
                        case STAND -> g.stand();
                        default -> throw new InvalidGameActionException(action, "Unsupported game action");
                    }

                    if (g.getState() == GameState.FINISHED) {
                        playerService.updateStats(g.getPlayerId(), g.getResult());
                    }

                    return gameRepository.save(g);
                })
                .map(GameMapper::toDto);
    }

    @Override
    public Mono<Void> removeGame(String id) {
        return gameRepository.findById(id)
                .switchIfEmpty(Mono.error(new GameNotFoundException(id)))
                .flatMap(gameRepository::delete);
    }
}
