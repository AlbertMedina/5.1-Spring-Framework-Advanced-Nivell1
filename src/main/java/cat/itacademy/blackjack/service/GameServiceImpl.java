package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.CreateGameDTO;
import cat.itacademy.blackjack.dto.GameDTO;
import cat.itacademy.blackjack.dto.PlayGameDTO;
import reactor.core.publisher.Mono;

public class GameServiceImpl implements GameService {
    @Override
    public Mono<GameDTO> createGame(CreateGameDTO createGameDTO) {
        return null;
    }

    @Override
    public Mono<GameDTO> getGameInfo(String id) {
        return null;
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
