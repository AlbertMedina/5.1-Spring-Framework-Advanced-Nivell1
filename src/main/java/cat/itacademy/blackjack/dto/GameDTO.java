package cat.itacademy.blackjack.dto;

import cat.itacademy.blackjack.model.GameResult;
import cat.itacademy.blackjack.model.GameState;

public record GameDTO(
        String id,
        Long playerId,
        HandDTO playerHand,
        HandDTO dealerHand,
        GameState state,
        GameResult result
) {
}
