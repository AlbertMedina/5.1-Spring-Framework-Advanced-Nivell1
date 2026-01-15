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

    public int getValue() {
        int value = 0;
        int numberOfAces = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank() == Rank.ACE) {
                numberOfAces++;
            }
        }

        while (value > 21 && numberOfAces > 0) {
            value -= 10;
            numberOfAces--;
        }

        return value;
    }

    public void pickCard(List<Card> shoe) {
        cards.add(shoe.removeFirst());
    }

    public static Hand newHand(List<Card> shoe) {
        return new Hand(List.of(shoe.removeFirst(), shoe.removeFirst()));
    }
}
