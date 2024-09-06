package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.response.Response;
import com.learn.javabackend.services.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user2")
public class User2Controller {

    @Autowired
    private User2Service user2Service;

    @PostMapping
    public ResponseEntity<Response<String>> createUser(@RequestBody UserEntity userData) {
        return user2Service.createUser(userData);
    }

    @GetMapping
    public ResponseEntity<Response<List<UserEntity>>> getAllUsers() {
        return user2Service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<UserEntity>> getUserById(@PathVariable String id) {
        return user2Service.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<UserEntity>> updateUser(@PathVariable String id, @RequestBody UserEntity userData) {
        return user2Service.updateUser(id, userData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteUser(@PathVariable String id) {
        return user2Service.deleteUser(id);
    }
}
