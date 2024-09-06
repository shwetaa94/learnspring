package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.TodoEntity;
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
    private ResponseEntityService todoService;

    @PostMapping
    public ResponseEntity<Response<String>> createUser(@RequestBody TodoEntity userData) {
        return todoService.createUser(userData);
    }

    @GetMapping
    public ResponseEntity<Response<List<TodoEntity>>> getAllUsers() {
        return todoService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<TodoEntity>> getUserById(@PathVariable String id) {
        return todoService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<TodoEntity>> updateUser(@PathVariable String id, @RequestBody TodoEntity userData) {
        return todoService.updateUser(id, userData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteUser(@PathVariable String id) {
        return todoService.deleteUser(id);
    }
}
