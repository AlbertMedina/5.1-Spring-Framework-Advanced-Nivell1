package cat.itacademy.blackjack.mapper;

import cat.itacademy.blackjack.dto.PlayerDTO;
import cat.itacademy.blackjack.model.Player;

public class PlayerMapper {

    public static PlayerDTO toDto(Player player) {
        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getNumberOfWins(),
                player.getNumberOfTies(),
                player.getNumberOfLosses()
        );
    }
}
