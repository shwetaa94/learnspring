package com.learn.javabackend.services;

import com.learn.javabackend.entity.TodoEntity;
import com.learn.javabackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Component
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void createTodo(TodoEntity todoData){
        todoRepository.insert(todoData);
    }

    public List<TodoEntity> getAllTodos(){
        return todoRepository.findAll();
    }

    public TodoEntity getTodoById(String Id){
        Optional<TodoEntity> user = todoRepository.findById(Id);
        return user.orElse(null);
    }

    public TodoEntity updateTodo(String Id, TodoEntity updatedData){
        Optional<TodoEntity> user = todoRepository.findById(Id);
        if(user.isPresent()){
            TodoEntity existingUser = user.get();

            if(updatedData.getTitle()!=null){
                existingUser.setTitle(updatedData.getTitle());
            }
            if(updatedData.getContent()!=null){
                existingUser.setContent(updatedData.getContent());
            }
            return todoRepository.save(existingUser);
        }
        return user.orElse(null);
    }

    public TodoEntity deleteTodo(String Id){
        Optional<TodoEntity> user = todoRepository.findById(Id);
        if(user.isPresent()){
             todoRepository.deleteById(Id);
        }
        return user.orElse(null);
    }
}
