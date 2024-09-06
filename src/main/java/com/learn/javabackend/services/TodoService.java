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

    public void createUser(TodoEntity userData){
        todoRepository.insert(userData);
    }

    public List<TodoEntity> getAllUsers(){
        return todoRepository.findAll();
    }

    public TodoEntity getUserById(String Id){
        Optional<TodoEntity> user = todoRepository.findById(Id);
        return user.orElse(null);
    }

    public TodoEntity updateUser(String Id, TodoEntity updatedData){
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

    public TodoEntity deleteUser(String Id){
        Optional<TodoEntity> user = todoRepository.findById(Id);
        if(user.isPresent()){
             todoRepository.deleteById(Id);
        }
        return user.orElse(null);
    }
}
