package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;

import java.util.List;

public interface PlayerService {

    PlayerDTO updatePlayerName(Long id, UpdatePlayerDTO playerDTO);

    List<PlayerDTO> getPlayersRanking();
}
