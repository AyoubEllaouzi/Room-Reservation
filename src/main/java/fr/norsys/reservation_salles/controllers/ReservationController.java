package fr.norsys.reservation_salles.controllers;

import fr.norsys.reservation_salles.constants.ReservationConstants;
import fr.norsys.reservation_salles.dto.ResponseDto;
import fr.norsys.reservation_salles.entities.Reservation;
import fr.norsys.reservation_salles.services.impl.ReservationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservations")
@Validated
public class ReservationController {
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveReservation(@Valid @RequestBody Reservation reservation) {
        reservationService.reserveRoom(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(ReservationConstants.STATUS_201,ReservationConstants.MESSAGE_201));


    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateReservation(@PathVariable Long id, @Valid @RequestBody Reservation updatedReservation) {
        reservationService.updateReservation(id, updatedReservation);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ReservationConstants.STATUS_200,ReservationConstants.MESSAGE_200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ReservationConstants.STATUS_200,ReservationConstants.MESSAGE_200));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservation(id);
        return ResponseEntity.status(HttpStatus.OK).body(reservation);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservation();
        return ResponseEntity.status(HttpStatus.OK).body(reservations);
    }
}
