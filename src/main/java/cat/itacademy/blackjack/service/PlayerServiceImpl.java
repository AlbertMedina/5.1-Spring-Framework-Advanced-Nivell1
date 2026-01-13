package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;
import cat.itacademy.blackjack.model.Player;
import cat.itacademy.blackjack.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO updatePlayerName(Long id, UpdatePlayerDTO updatePlayerDTO) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player " + id + " not found"));
        player.setName(updatePlayerDTO.name());
        Player savedPlayer = playerRepository.save(player);
        return new PlayerDTO(savedPlayer.getId(), savedPlayer.getName(), savedPlayer.getNumberOfWins(), savedPlayer.getNumberOfTies(), savedPlayer.getNumberOfLosses());
    }

    @Override
    public List<PlayerDTO> getPlayersRanking() {
        return playerRepository.findAllByOrderByNumberOfWinsDesc().stream().map(p -> new PlayerDTO(p.getId(), p.getName(), p.getNumberOfWins(), p.getNumberOfTies(), p.getNumberOfLosses())).toList();
    }
}
