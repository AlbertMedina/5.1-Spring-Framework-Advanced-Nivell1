package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;
import cat.itacademy.blackjack.exception.PlayerNotFoundException;
import cat.itacademy.blackjack.mapper.PlayerMapper;
import cat.itacademy.blackjack.model.Player;
import cat.itacademy.blackjack.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public PlayerDTO updatePlayerName(Long id, UpdatePlayerDTO updatePlayerDTO) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));

        player.setName(updatePlayerDTO.name());
        
        Player savedPlayer = playerRepository.save(player);
        return PlayerMapper.toDto(savedPlayer);
    }

    @Override
    public List<PlayerDTO> getPlayersRanking() {
        return playerRepository.findAllByOrderByNumberOfWinsDesc()
                .stream()
                .map(PlayerMapper::toDto)
                .toList();
    }

    @Override
    public Player getOrCreatePlayer(String playerName) {
        return playerRepository.findByNameIgnoreCase(playerName)
                .orElseGet(() -> playerRepository.save(new Player(playerName)));
    }
}
