package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public String createUser(@RequestBody UserEntity userData){
        todoService.createUser(userData);
        return "Data Saved Successfully";
    }

    @GetMapping
    public List<UserEntity> getAllUsers(){
        return todoService.getAllUsers();
    }
    @GetMapping("/{Id}")
    public UserEntity getUserById(@PathVariable String Id){
        return todoService.getUserById(Id);
    }
    @PutMapping("/{Id}")
    public UserEntity updateUser(@PathVariable String Id, @RequestBody UserEntity userData){
        return todoService.updateUser(Id, userData);
    }

    @DeleteMapping("/{Id}")
    public UserEntity updateUser(@PathVariable String Id){
        return todoService.deleteUser(Id);
    }

}
