package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.response.Response;
import com.learn.javabackend.services.ResponseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/response")
public class ResponseEntityController {

    @Autowired
    private ResponseEntityService userService;

    @PostMapping
    public ResponseEntity<Response<String>> createUser(@RequestBody UserEntity userData) {
        return userService.createUser(userData);
    }

    @GetMapping
    public ResponseEntity<Response<List<UserEntity>>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<UserEntity>> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<UserEntity>> updateUser(@PathVariable String id, @RequestBody UserEntity userData) {
        return userService.updateUser(id, userData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}