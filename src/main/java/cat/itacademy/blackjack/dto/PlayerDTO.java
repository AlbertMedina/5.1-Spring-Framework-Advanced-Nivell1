package cat.itacademy.blackjack.dto;

public record PlayerDTO(
        Long id,
        String name,
        int numberOfWins,
        int numberOfTies,
        int numberOfLosses
) {}
