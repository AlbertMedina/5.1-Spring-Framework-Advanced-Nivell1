package cat.itacademy.blackjack.exception;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String id) {
        super("Game " + id + " not found");
    }
}
