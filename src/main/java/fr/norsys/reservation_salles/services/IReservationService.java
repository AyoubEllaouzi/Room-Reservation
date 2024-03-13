package fr.norsys.reservation_salles.services;

import fr.norsys.reservation_salles.entities.Reservation;
import fr.norsys.reservation_salles.entities.Room;
import fr.norsys.reservation_salles.entities.User;

import java.util.List;

public interface IReservationService {
    void reserveRoom(Reservation reservation);
    void updateReservation(Long id, Reservation reservation);
    void deleteReservation(Long id);
    Reservation getReservation(Long id);
    List<Reservation> getAllReservation();
}
