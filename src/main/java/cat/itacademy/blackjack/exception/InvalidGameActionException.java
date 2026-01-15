package cat.itacademy.blackjack.exception;

import cat.itacademy.blackjack.model.GameAction;

public class InvalidGameActionException extends RuntimeException {
    public InvalidGameActionException(GameAction action, String detail) {
        super(action + " is not valid: " + detail);
    }
}
