package cat.itacademy.blackjack.model;

import java.util.List;

public class Hand {

    private List<Card> cards;

    public Hand() {
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public static Hand newHand(List<Card> shoe) {
        return new Hand(List.of(shoe.removeFirst(), shoe.removeFirst()));
    }
}
