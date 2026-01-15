package cat.itacademy.blackjack.dto;

import cat.itacademy.blackjack.model.GameAction;
import jakarta.validation.constraints.NotNull;

public record PlayGameDTO(
        @NotNull GameAction action
) {
}
