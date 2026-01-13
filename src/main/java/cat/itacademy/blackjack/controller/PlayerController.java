package cat.itacademy.blackjack.controller;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;
import cat.itacademy.blackjack.service.PlayerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerServiceImpl playerService;

    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<PlayerDTO> updatePlayerName(@PathVariable Long id, @RequestBody @Valid UpdatePlayerDTO playerDTORequest) {
        PlayerDTO player = playerService.updatePlayerName(id, playerDTORequest);
        return ResponseEntity.ok(player);
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<PlayerDTO>> getPlayersRanking() {
        List<PlayerDTO> players = playerService.getPlayersRanking();
        return ResponseEntity.ok(players);
    }
}


