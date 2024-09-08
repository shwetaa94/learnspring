package com.learn.javabackend.services;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.repository.UserRepository;
import com.learn.javabackend.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public ResponseEntity<Response<String>> createUser(UserEntity userData) {
        userRepository.save(userData);
        Response<String> response = new Response<>("success", "User created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get all users
    public ResponseEntity<Response<List<UserEntity>>> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        Response<List<UserEntity>> response = new Response<>("success", "Users retrieved successfully", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get user by ID
    public ResponseEntity<Response<UserEntity>> getUserById(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            Response<UserEntity> response = new Response<>("success", "User retrieved successfully", user.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<UserEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing user
    public ResponseEntity<Response<UserEntity>> updateUser(String id, UserEntity updatedData) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserEntity existingUser = user.get();
            if (updatedData.getUsername() != null) {
                existingUser.setUsername(updatedData.getUsername());
            }
            UserEntity updatedUser = userRepository.save(existingUser);
            Response<UserEntity> response = new Response<>("success", "User updated successfully", updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<UserEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a user by ID
    public ResponseEntity<Response<String>> deleteUser(String id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            Response<String> response = new Response<>("success", "User deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } else {
            Response<String> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
