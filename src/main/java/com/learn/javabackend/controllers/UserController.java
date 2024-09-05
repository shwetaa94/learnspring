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
    @GetMapping("/{Id}")
    public UserEntity getUserById(@PathVariable String Id){
        return userService.getUserById(Id);
    }
    @PutMapping("/{Id}")
    public UserEntity updateUser(@PathVariable String Id, @RequestBody UserEntity userData){
        return userService.updateUser(Id, userData);
    }

}
