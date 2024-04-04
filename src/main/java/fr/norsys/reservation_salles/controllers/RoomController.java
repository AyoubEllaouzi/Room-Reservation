package fr.norsys.reservation_salles.controllers;

import fr.norsys.reservation_salles.constants.RoomConstants;
import fr.norsys.reservation_salles.dto.ResponseDto;
import fr.norsys.reservation_salles.entities.Room;
import fr.norsys.reservation_salles.services.impl.RoomService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:5173")
@Validated
public class RoomController {
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveAuthor(@Valid @RequestBody Room room) {
        roomService.saveRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(RoomConstants.STATUS_201,RoomConstants.MESSAGE_201));


    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateAuthor(@PathVariable Long id, @Valid @RequestBody Room updatedRoom) {
        roomService.updateRoom(id, updatedRoom);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(RoomConstants.STATUS_200,RoomConstants.MESSAGE_200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteAuthor(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(RoomConstants.STATUS_200,RoomConstants.MESSAGE_200));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getAuthor(@PathVariable Long id) {
        Room room = roomService.getRoom(id);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllAuthor() {
        List<Room> rooms = roomService.getAllRoom();
        return ResponseEntity.status(HttpStatus.OK).body(rooms);
    }
}
