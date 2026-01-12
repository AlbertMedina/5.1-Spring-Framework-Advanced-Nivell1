package cat.itacademy.blackjack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePlayerDTO(
        @NotNull @NotBlank String name
) {}
