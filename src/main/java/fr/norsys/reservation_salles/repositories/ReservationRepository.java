package fr.norsys.reservation_salles.repositories;

import fr.norsys.reservation_salles.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
