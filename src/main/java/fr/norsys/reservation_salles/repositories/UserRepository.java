package fr.norsys.reservation_salles.repositories;

import fr.norsys.reservation_salles.entities.Room;
import fr.norsys.reservation_salles.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
