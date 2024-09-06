package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.response.Response;
import com.learn.javabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<Response<String>> createUser(@RequestBody UserEntity userData) {
        return userService.createUser(userData);
    }

    // Get all users
    @GetMapping
    public ResponseEntity<Response<List<UserEntity>>> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Response<UserEntity>> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<Response<UserEntity>> updateUser(@PathVariable String id, @RequestBody UserEntity userData) {
        return userService.updateUser(id, userData);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
