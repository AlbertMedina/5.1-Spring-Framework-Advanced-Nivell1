package cat.itacademy.blackjack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePlayerDTO(
        @NotNull @NotBlank String name
) {}
