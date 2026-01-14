package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.*;
import cat.itacademy.blackjack.exception.GameNotFoundException;
import cat.itacademy.blackjack.model.Game;
import cat.itacademy.blackjack.repository.GameRepository;
import reactor.core.publisher.Mono;

public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Mono<GameDTO> createGame(CreateGameDTO createGameDTO) {
        return null;
    }

    @Override
    public Mono<GameDTO> getGameInfo(String id) {
        Mono<Game> game = gameRepository.findById(id).switchIfEmpty(Mono.error(new GameNotFoundException(id)));
        return game.map(g -> new GameDTO(g.getId(),
                g.getPlayerId(),
                new HandDTO(g.getPlayerHand().getCards().stream().map(c -> new CardDTO(c.getRank(), c.getSuit())).toList()),
                new HandDTO(g.getDealerHand().getCards().stream().map(c -> new CardDTO(c.getRank(), c.getSuit())).toList())));
    }

    @Override
    public Mono<GameDTO> playGame(String id, PlayGameDTO playGameDTO) {
        return null;
    }

    @Override
    public Mono<Void> removeGame(String id) {
        return null;
    }
}
