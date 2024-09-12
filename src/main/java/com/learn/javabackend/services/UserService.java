package com.learn.javabackend.services;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.repository.TodoRepository;
import com.learn.javabackend.repository.UserRepository;
import com.learn.javabackend.response.Response;
import org.apache.catalina.User;
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

    @Autowired
    private TodoRepository todoRepository;

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
    public ResponseEntity<Response<UserEntity>> getUserById(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user!=null) {
            Response<UserEntity> response = new Response<>("success", "User retrieved successfully", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<UserEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing user
    public ResponseEntity<Response<UserEntity>> updateUser(String username, UserEntity updatedData) {
        UserEntity user = userRepository.findByUsername(username);
        if (user!=null) {
            user.setUsername(updatedData.getUsername());
            user.setPassword(updatedData.getPassword());

            UserEntity updatedUser = userRepository.save(user);
            Response<UserEntity> response = new Response<>("success", "User updated successfully", updatedUser);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response<UserEntity> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a user by ID
    public ResponseEntity<Response<String>> deleteUser(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user!=null) {
            // Delete all todos associated with the user
            todoRepository.deleteAllByUser(user);
            //Delete the user
            userRepository.deleteById(user.getId());

            Response<String> response = new Response<>("success", "User deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } else {
            Response<String> response = new Response<>("error", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
