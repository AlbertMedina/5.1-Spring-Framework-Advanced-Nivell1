package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;
import cat.itacademy.blackjack.model.GameResult;
import cat.itacademy.blackjack.model.Player;

import java.util.List;

public interface PlayerService {

    PlayerDTO updatePlayerName(Long id, UpdatePlayerDTO playerDTO);

    Player getOrCreatePlayer(String playerName);

    List<PlayerDTO> getPlayersRanking();

    void updateStats(Long id, GameResult gameResult);
}
