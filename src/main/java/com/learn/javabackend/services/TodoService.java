package com.learn.javabackend.services;

import com.learn.javabackend.entity.UserEntity;
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

    public void createUser(UserEntity userData){
        todoRepository.insert(userData);
    }

    public List<UserEntity> getAllUsers(){
        return todoRepository.findAll();
    }

    public UserEntity getUserById(String Id){
        Optional<UserEntity> user = todoRepository.findById(Id);
        return user.orElse(null);
    }

    public UserEntity updateUser(String Id, UserEntity updatedData){
        Optional<UserEntity> user = todoRepository.findById(Id);
        if(user.isPresent()){
            UserEntity existingUser = user.get();

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

    public UserEntity deleteUser(String Id){
        Optional<UserEntity> user = todoRepository.findById(Id);
        if(user.isPresent()){
             todoRepository.deleteById(Id);
        }
        return user.orElse(null);
    }
}
