package com.learn.javabackend.services;

import com.learn.javabackend.entity.UserEntity;
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

    public ResponseEntity<Response<String>> createUser(UserEntity userData) {
        todoRepository.save(userData);
        Response<String> response = new Response<>("success", "User created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Response<List<UserEntity>>> getAllUsers() {
        List<UserEntity> users = todoRepository.findAll();
        Response<List<UserEntity>> response = new Response<>("success", "Users retrieved successfully", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<Response<UserEntity>> getUserById(String id) {
        Optional<UserEntity> user = todoRepository.findById(id);
        if (user.isPresent()) {
            Response<UserEntity> response = new Response<>("success", "User retrieved successfully", user.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<UserEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Response<UserEntity>> updateUser(String id, UserEntity updatedData) {
        Optional<UserEntity> user = todoRepository.findById(id);
        if (user.isPresent()) {
            UserEntity existingUser = user.get();
            if (updatedData.getTitle() != null) {
                existingUser.setTitle(updatedData.getTitle());
            }
            if (updatedData.getContent() != null) {
                existingUser.setContent(updatedData.getContent());
            }
            UserEntity updatedUser = todoRepository.save(existingUser);
            Response<UserEntity> response = new Response<>("success", "User updated successfully", updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<UserEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Response<String>> deleteUser(String id) {
        Optional<UserEntity> user = todoRepository.findById(id);
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
