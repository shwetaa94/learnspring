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
    public String createTodo(@RequestBody TodoEntity todoData){
        todoService.createTodo(todoData);
        return "Data Saved Successfully";
    }

    @GetMapping
    public List<TodoEntity> getAllTodos(){
        return todoService.getAllTodos();
    }
    @GetMapping("/{Id}")
    public TodoEntity getTodoById(@PathVariable String Id){
        return todoService.getTodoById(Id);
    }
    @PutMapping("/{Id}")
    public TodoEntity updateTodo(@PathVariable String Id, @RequestBody TodoEntity userData){
        return todoService.updateTodo(Id, userData);
    }

    @DeleteMapping("/{Id}")
    public TodoEntity deleteUser(@PathVariable String Id){
        return todoService.deleteTodo(Id);
    }

}
