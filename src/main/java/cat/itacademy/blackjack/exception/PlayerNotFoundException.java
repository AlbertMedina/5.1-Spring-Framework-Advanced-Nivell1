package cat.itacademy.blackjack.exception;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Player " + id + " not found");
    }
}
