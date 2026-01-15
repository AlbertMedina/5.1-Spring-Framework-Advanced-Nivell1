package cat.itacademy.blackjack.exception;

import cat.itacademy.blackjack.model.GameAction;

public class InvalidGameActionException extends RuntimeException {
    public InvalidGameActionException(GameAction action) {
        super(action + " is not a valid game action");
    }
}
