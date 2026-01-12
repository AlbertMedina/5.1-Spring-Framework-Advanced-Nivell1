package cat.itacademy.blackjack.controller;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @PutMapping("/player/{id}")
    public ResponseEntity<PlayerDTO> updatePlayerName(@PathVariable Long id, @RequestBody @Valid UpdatePlayerDTO playerDTORequest) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<PlayerDTO>> getPlayersRanking() {
        List<PlayerDTO> players = List.of();
        return ResponseEntity.ok(players);
    }
}


