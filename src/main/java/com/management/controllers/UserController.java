package com.management.controllers;

import com.management.model.dto.UserDto;
import com.management.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.addNewUser(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.updateUser(userDto);
        return ResponseEntity.ok(userDto1);
    }

    @DeleteMapping
    public ResponseEntity<UserDto> deleteUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = userService.deleteUser(userDto);
        return ResponseEntity.ok(userDto1);
    }
}
