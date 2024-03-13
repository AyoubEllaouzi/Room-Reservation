package fr.norsys.reservation_salles.services;

import fr.norsys.reservation_salles.entities.Room;

import java.util.List;

public interface IRoomService {
    void saveRoom(Room book);
    void updateRoom(Long id , Room room);
    void deleteRoom(Long id);
    Room getRoom(Long id);
    List<Room> getAllRoom();
}
