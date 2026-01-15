package cat.itacademy.blackjack.controller;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;
import cat.itacademy.blackjack.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Operation(summary = "Update player name")
    @ApiResponse(responseCode = "200", description = "Player name updated successfully")
    @PutMapping("/player/{id}")
    public ResponseEntity<PlayerDTO> updatePlayerName(@PathVariable Long id, @RequestBody @Valid UpdatePlayerDTO playerDTORequest) {
        PlayerDTO player = playerService.updatePlayerName(id, playerDTORequest);
        return ResponseEntity.ok(player);
    }

    @Operation(summary = "Get players ranking")
    @ApiResponse(responseCode = "200", description = "Player ranking retrieved successfully")
    @GetMapping("/ranking")
    public ResponseEntity<List<PlayerDTO>> getPlayersRanking() {
        List<PlayerDTO> players = playerService.getPlayersRanking();
        return ResponseEntity.ok(players);
    }
}


