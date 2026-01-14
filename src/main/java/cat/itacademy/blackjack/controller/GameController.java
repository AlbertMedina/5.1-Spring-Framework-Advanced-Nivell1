package cat.itacademy.blackjack.controller;

import cat.itacademy.blackjack.dto.CreateGameDTO;
import cat.itacademy.blackjack.dto.GameDTO;
import cat.itacademy.blackjack.dto.PlayGameDTO;
import cat.itacademy.blackjack.service.GameService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/game/new")
    public Mono<GameDTO> createGame(@RequestBody @Valid CreateGameDTO createGameDTO) {
        return gameService.createGame(createGameDTO);
    }

    @PutMapping("/game/{id}/delete")
    public Mono<GameDTO> playGame(@PathVariable String id, @RequestBody @Valid PlayGameDTO playGameDTO) {
        return gameService.playGame(id, playGameDTO);
    }

    @GetMapping("/game/{id}")
    public Mono<GameDTO> getGameInfoById(@PathVariable String id) {
        return gameService.getGameInfo(id);
    }

    @DeleteMapping("/game/{id}/delete")
    public Mono<Void> removeGame(@PathVariable String id) {
        return gameService.removeGame(id);
    }
}
