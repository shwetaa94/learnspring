package com.learn.javabackend.services;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void createUser(UserEntity userData){
        userRepo.insert(userData);
    }

    public List<UserEntity> getAllUsers(){
        return userRepo.findAll();
    }
}
