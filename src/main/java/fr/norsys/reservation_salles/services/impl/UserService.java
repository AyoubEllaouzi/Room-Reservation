package fr.norsys.reservation_salles.services.impl;

import fr.norsys.reservation_salles.entities.User;
import fr.norsys.reservation_salles.exceptions.ResourceNotFoundException;
import fr.norsys.reservation_salles.repositories.UserRepository;
import fr.norsys.reservation_salles.services.IUserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class UserService implements IUserService {
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id : "+id));

        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id : "+id));
        userRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User id : "+id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
