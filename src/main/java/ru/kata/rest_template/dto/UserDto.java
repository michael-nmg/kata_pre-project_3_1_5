package ru.kata.rest_template.dto;

import org.springframework.http.ResponseEntity;
import ru.kata.rest_template.model.User;

public interface UserDto {
    ResponseEntity createUser(User user);

    ResponseEntity getAllUsers();

    ResponseEntity editUser(User user);

    ResponseEntity deleteUser(Long id);

    void setCookies(String cookie);

}