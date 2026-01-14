package cat.itacademy.blackjack.dto;

import cat.itacademy.blackjack.model.Rank;
import cat.itacademy.blackjack.model.Suit;

public record CardDTO(
        Rank rank,
        Suit suit
) {
}
