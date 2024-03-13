package fr.norsys.reservation_salles.services.impl;

import fr.norsys.reservation_salles.entities.Reservation;
import fr.norsys.reservation_salles.exceptions.ResourceNotFoundException;
import fr.norsys.reservation_salles.repositories.ReservationRepository;
import fr.norsys.reservation_salles.services.IReservationService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ReservationService implements IReservationService {
    private ReservationRepository reservationRepository;

    @Override
    public void reserveRoom(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Long id, Reservation updatedReservation) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation id : "+id));

        reservation.setUser(updatedReservation.getUser());
        reservation.setRoom(updatedReservation.getRoom());
        reservation.setStartTime(updatedReservation.getStartTime());
        reservation.setEndTime(updatedReservation.getEndTime());
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation id : "+id));
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation id : "+id));
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }
}
