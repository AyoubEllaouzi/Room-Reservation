package fr.norsys.reservation_salles.services.impl;

import fr.norsys.reservation_salles.entities.Room;
import fr.norsys.reservation_salles.exceptions.ResourceNotFoundException;
import fr.norsys.reservation_salles.repositories.RoomRepository;
import fr.norsys.reservation_salles.services.IRoomService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class RoomService implements IRoomService {
    private RoomRepository roomRepository;

    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void updateRoom(Long id, Room updatedRoom) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room id : "+id));

        room.setRoomId(updatedRoom.getRoomId());
        room.setCapacity(updatedRoom.getCapacity());
        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room id : "+id));
        roomRepository.deleteById(id);
    }

    @Override
    public Room getRoom(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room id : "+id));

    }

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }
}
