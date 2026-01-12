package cat.itacademy.blackjack.repository;

import cat.itacademy.blackjack.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
