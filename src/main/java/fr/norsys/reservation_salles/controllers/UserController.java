package fr.norsys.reservation_salles.controllers;

import fr.norsys.reservation_salles.constants.UserConstants;
import fr.norsys.reservation_salles.dto.ResponseDto;
import fr.norsys.reservation_salles.entities.User;
import fr.norsys.reservation_salles.services.impl.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@Validated
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto> saveUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(UserConstants.STATUS_201,UserConstants.MESSAGE_201));


    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        userService.updateUser(id, updatedUser);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(UserConstants.STATUS_200,UserConstants.MESSAGE_200));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(UserConstants.STATUS_200,UserConstants.MESSAGE_200));

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
