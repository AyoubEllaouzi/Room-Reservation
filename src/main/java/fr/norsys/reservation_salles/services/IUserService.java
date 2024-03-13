package fr.norsys.reservation_salles.services;

import fr.norsys.reservation_salles.entities.Room;
import fr.norsys.reservation_salles.entities.User;

import java.util.List;

public interface IUserService {
    void saveUser(User user);
    void updateUser(Long id , User user);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUser();
}
