package com.learn.javabackend.services;

import com.learn.javabackend.entity.TodoEntity;
import com.learn.javabackend.repository.TodoRepository;
import com.learn.javabackend.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseEntityService {

    @Autowired
    private TodoRepository todoRepository;

    public ResponseEntity<Response<String>> createUser(TodoEntity userData) {
        todoRepository.save(userData);
        Response<String> response = new Response<>("success", "User created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Response<List<TodoEntity>>> getAllUsers() {
        List<TodoEntity> users = todoRepository.findAll();
        Response<List<TodoEntity>> response = new Response<>("success", "Users retrieved successfully", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Response<TodoEntity>> getUserById(String id) {
        Optional<TodoEntity> user = todoRepository.findById(id);
        if (user.isPresent()) {
            Response<TodoEntity> response = new Response<>("success", "User retrieved successfully", user.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<TodoEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Response<TodoEntity>> updateUser(String id, TodoEntity updatedData) {
        Optional<TodoEntity> user = todoRepository.findById(id);
        if (user.isPresent()) {
            TodoEntity existingUser = user.get();
            if (updatedData.getTitle() != null) {
                existingUser.setTitle(updatedData.getTitle());
            }
            if (updatedData.getContent() != null) {
                existingUser.setContent(updatedData.getContent());
            }
            TodoEntity updatedUser = todoRepository.save(existingUser);
            Response<TodoEntity> response = new Response<>("success", "User updated successfully", updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<TodoEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Response<String>> deleteUser(String id) {
        Optional<TodoEntity> user = todoRepository.findById(id);
        if (user.isPresent()) {
            todoRepository.deleteById(id);
            Response<String> response = new Response<>("success", "User deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } else {
            Response<String> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
