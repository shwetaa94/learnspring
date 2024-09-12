package com.learn.javabackend.controllers;

import com.learn.javabackend.entity.TodoEntity;
import com.learn.javabackend.response.Response;
import com.learn.javabackend.services.TodoService;
import com.learn.javabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService ;


    @PostMapping("/{username}")
    public ResponseEntity<Response<String>> createTodo(@RequestBody TodoEntity todoData, @PathVariable String username) {
        return todoService.createTodo(todoData, username);
    }

    @GetMapping
    public ResponseEntity<Response<List<TodoEntity>>> getAllUsers() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<TodoEntity>> getTodoById(@PathVariable String id) {
        return todoService.getTodoById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<TodoEntity>> updateTodo(@PathVariable String id, @RequestBody TodoEntity userData) {
        return todoService.updateTodo(id, userData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteTodor(@PathVariable String id) {
        return todoService.deleteTodo(id);
    }
}
