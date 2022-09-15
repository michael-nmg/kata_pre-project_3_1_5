package ru.kata.rest_template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import ru.kata.rest_template.dto.UserDto;
import ru.kata.rest_template.model.User;

@Repository
public class UserServiceImp implements UserService {

    private final UserDto userDto;

    @Autowired
    public UserServiceImp(UserDto userDto) {
        this.userDto = userDto;
    }

    public ResponseEntity createUser(User user) {
        return userDto.createUser(user);
    }

    public ResponseEntity getAllUsers() {
        return userDto.getAllUsers();
    }

    public ResponseEntity editUser(User user) {
        return userDto.editUser(user);
    }

    public ResponseEntity deleteUser(Long id) {
        return userDto.deleteUser(id);
    }

    public void setCookies(String cookie) {
        userDto.setCookies(cookie);
    }

}