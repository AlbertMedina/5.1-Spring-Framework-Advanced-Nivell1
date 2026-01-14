package cat.itacademy.blackjack.repository;

import cat.itacademy.blackjack.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {
}
