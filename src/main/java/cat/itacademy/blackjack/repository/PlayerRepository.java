package cat.itacademy.blackjack.repository;

import cat.itacademy.blackjack.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByNameIgnoreCase(String name);

    List<Player> findAllByOrderByNumberOfWinsDesc();
}
