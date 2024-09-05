package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody UserEntity userData){
        userService.createUser(userData);
        return "Data Saved Successfully";
    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

}
