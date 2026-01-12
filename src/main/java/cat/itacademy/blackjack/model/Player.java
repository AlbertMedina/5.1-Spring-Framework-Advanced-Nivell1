package cat.itacademy.blackjack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int numberOfWins;
    private int numberOfTies;
    private int numberOfLosses;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.numberOfWins = 0;
        this.numberOfTies = 0;
        this.numberOfLosses = 0;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getNumberOfTies() {
        return numberOfTies;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }
}
