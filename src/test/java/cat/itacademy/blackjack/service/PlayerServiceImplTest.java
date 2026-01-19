package cat.itacademy.blackjack.service;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.dto.UpdatePlayerDTO;
import cat.itacademy.blackjack.exception.PlayerNotFoundException;
import cat.itacademy.blackjack.model.GameResult;
import cat.itacademy.blackjack.model.Player;
import cat.itacademy.blackjack.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Test
    void updatePlayerName_shouldUpdateNameWhenPlayerExists() {
        Player player = new Player("PlayerName");

        UpdatePlayerDTO request = new UpdatePlayerDTO("NewName");

        when(playerRepository.findById(1L))
                .thenReturn(Optional.of(player));

        when(playerRepository.save(player))
                .thenReturn(player);

        PlayerDTO result = playerService.updatePlayerName(1L, request);

        assertEquals("NewName", result.name());
    }

    @Test
    void updatePlayerName_shouldThrowExceptionWhenPlayerDoesNotExist() {
        UpdatePlayerDTO request = new UpdatePlayerDTO("NewName");

        when(playerRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(PlayerNotFoundException.class, () -> playerService.updatePlayerName(1L, request));
    }

    @Test
    void getPlayersRanking_shouldReturnPlayersOrderedByNumberOfWins() {
        Player player1 = new Player("Player1");
        player1.win();
        player1.win();

        Player player2 = new Player("Player2");
        player2.win();

        Player player3 = new Player("Player3");

        List<Player> players = List.of(player1, player2, player3);

        when(playerRepository.findAllByOrderByNumberOfWinsDesc())
                .thenReturn(players);

        List<PlayerDTO> result = playerService.getPlayersRanking();

        assertEquals(3, result.size());
        assertEquals("Player1", result.get(0).name());
        assertEquals("Player2", result.get(1).name());
        assertEquals("Player3", result.get(2).name());
    }

    @Test
    void getOrCreatePlayer_shouldReturnExistingPlayerWhenPlayerExists() {
        Player player = new Player("PlayerName");

        when(playerRepository.findByNameIgnoreCase("PlayerName"))
                .thenReturn(Optional.of(player));

        Player result = playerService.getOrCreatePlayer("PlayerName");

        assertEquals(player, result);
    }

    @Test
    void getOrCreatePlayer_shouldCreateAndReturnPlayerWhenPlayerDoesNotExist() {
        Player newPlayer = new Player("PlayerName");

        when(playerRepository.findByNameIgnoreCase("PlayerName"))
                .thenReturn(Optional.empty());

        when(playerRepository.save(any(Player.class)))
                .thenReturn(newPlayer);

        Player result = playerService.getOrCreatePlayer("PlayerName");

        assertEquals("PlayerName", result.getName());
    }

    @Test
    void updateStats_shouldIncreaseWinsWhenPlayerWins() {
        Player player = new Player("PlayerName");

        when(playerRepository.findById(1L))
                .thenReturn(Optional.of(player));

        when(playerRepository.save(player))
                .thenReturn(player);

        playerService.updateStats(1L, GameResult.PLAYER_WINS);
        
        assertEquals(1, player.getNumberOfWins());
    }

    @Test
    void updateStats_shouldThrowExceptionWhenPlayerDoesNotExist() {
        when(playerRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                PlayerNotFoundException.class,
                () -> playerService.updateStats(1L, GameResult.PLAYER_WINS)
        );
    }
}
