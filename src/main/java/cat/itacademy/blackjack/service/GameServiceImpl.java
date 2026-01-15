package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.*;
import cat.itacademy.blackjack.exception.GameNotFoundException;
import cat.itacademy.blackjack.exception.InvalidGameActionException;
import cat.itacademy.blackjack.mapper.GameMapper;
import cat.itacademy.blackjack.model.Game;
import cat.itacademy.blackjack.model.GameAction;
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

        Game game = Game.newGame(player.getId());

        return gameRepository.save(game).map(GameMapper::toDto);
    }

    @Override
    public Mono<GameDTO> getGameInfo(String id) {
        Mono<Game> game = gameRepository.findById(id).switchIfEmpty(Mono.error(new GameNotFoundException(id)));

        return game.map(GameMapper::toDto);
    }

    @Override
    public Mono<GameDTO> playGame(String id, PlayGameDTO playGameDTO) {
        Mono<Game> game = gameRepository.findById(id).switchIfEmpty(Mono.error(new GameNotFoundException(id)));

        Mono<Game> updatedGame = game.flatMap(g -> {

            GameAction action = playGameDTO.action();

            if (action == GameAction.HIT) {
                g.hit();
            } else if (action == GameAction.STAND) {
                g.stand();
            } else {
                throw new InvalidGameActionException(action);
            }

            return gameRepository.save(g);
        });

        return updatedGame.map(GameMapper::toDto);
    }

    @Override
    public Mono<Void> removeGame(String id) {
        return gameRepository.findById(id)
                .switchIfEmpty(Mono.error(new GameNotFoundException(id)))
                .flatMap(gameRepository::delete);
    }
}
