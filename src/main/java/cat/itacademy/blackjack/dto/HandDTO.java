package cat.itacademy.blackjack.dto;

import java.util.List;

public record HandDTO(
        List<CardDTO> cards
) {
}
