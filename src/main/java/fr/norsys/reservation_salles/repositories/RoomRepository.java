package fr.norsys.reservation_salles.repositories;

import fr.norsys.reservation_salles.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
