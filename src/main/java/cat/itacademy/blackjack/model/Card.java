package cat.itacademy.blackjack.model;

public class Card {

    private int rank;
    private char suit;

    public Card() {
    }

    public Card(int rank, char suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }
}
