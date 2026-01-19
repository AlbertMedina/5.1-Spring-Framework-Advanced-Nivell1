package cat.itacademy.blackjack.mapper;

import cat.itacademy.blackjack.dto.CardDTO;
import cat.itacademy.blackjack.dto.GameDTO;
import cat.itacademy.blackjack.dto.HandDTO;
import cat.itacademy.blackjack.model.Card;
import cat.itacademy.blackjack.model.Game;
import cat.itacademy.blackjack.model.Hand;

public class GameMapper {

    public static GameDTO toDto(Game game) {
        return new GameDTO(
                game.getId(),
                game.getPlayerId(),
                handToDto(game.getPlayerHand()),
                handToDto(game.getDealerHand()),
                game.getState(),
                game.getResult()
        );
    }

    public static HandDTO handToDto(Hand hand) {
        return new HandDTO(hand.getCards()
                .stream()
                .map(GameMapper::cardToDto)
                .toList());
    }

    public static CardDTO cardToDto(Card card) {
        return new CardDTO(card.getRank(), card.getSuit());
    }
}
