package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.TodoEntity;
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
    public String createUser(@RequestBody TodoEntity userData){
        todoService.createUser(userData);
        return "Data Saved Successfully";
    }

    @GetMapping
    public List<TodoEntity> getAllUsers(){
        return todoService.getAllUsers();
    }
    @GetMapping("/{Id}")
    public TodoEntity getUserById(@PathVariable String Id){
        return todoService.getUserById(Id);
    }
    @PutMapping("/{Id}")
    public TodoEntity updateUser(@PathVariable String Id, @RequestBody TodoEntity userData){
        return todoService.updateUser(Id, userData);
    }

    @DeleteMapping("/{Id}")
    public TodoEntity updateUser(@PathVariable String Id){
        return todoService.deleteUser(Id);
    }

}
