package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.CreateGameDTO;
import cat.itacademy.blackjack.dto.GameDTO;
import cat.itacademy.blackjack.dto.PlayGameDTO;
import reactor.core.publisher.Mono;

public interface GameService {

    Mono<GameDTO> createGame(CreateGameDTO createGameDTO);

    Mono<GameDTO> getGameInfo(String id);

    Mono<GameDTO> playGame(String id, PlayGameDTO playGameDTO);

    Mono<Void> removeGame(String id);
}
