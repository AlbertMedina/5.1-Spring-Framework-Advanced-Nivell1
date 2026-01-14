package cat.itacademy.blackjack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "games")
public class Game {

    @Id
    private String id;

    private Long playerId;
    private List<Card> shoe;
    private Hand playerHand;
    private Hand dealerHand;

    public Game() {
    }

    public Game(Long playerId, List<Card> shoe, Hand playerHand, Hand dealerHand) {
        this.playerId = playerId;
        this.shoe = shoe;
        this.playerHand = playerHand;
        this.dealerHand = dealerHand;
    }

    public String getId() {
        return id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public List<Card> getShoe() {
        return List.copyOf(shoe);
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public static Game newGame(Long playerId) {

        List<Card> shoe = Card.newShuffledDeck();

        Hand playerHand = Hand.newHand(shoe);
        Hand dealerHand = Hand.newHand(shoe);

        return new Game(playerId, shoe, playerHand, dealerHand);
    }
}
