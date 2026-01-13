package cat.itacademy.blackjack.dto;

public record GameDTO(
        String id,
        Long playerId,
        HandDTO playerHand,
        HandDTO dealerHand
) {
}
