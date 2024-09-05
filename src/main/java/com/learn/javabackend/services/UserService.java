package com.learn.javabackend.services;

import com.learn.javabackend.entity.UserEntity;
import com.learn.javabackend.repository.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    public UserEntity getUserById(String Id){
        Optional<UserEntity> user = userRepo.findById(Id);
        return user.orElse(null);
    }

    public UserEntity updateUser(String Id, UserEntity updatedData){
        Optional<UserEntity> user = userRepo.findById(Id);
        if(user.isPresent()){
            UserEntity existingUser = user.get();

            if(updatedData.getTitle()!=null){
                existingUser.setTitle(updatedData.getTitle());
            }
            if(updatedData.getContent()!=null){
                existingUser.setContent(updatedData.getContent());
            }
            return userRepo.save(existingUser);
        }
        else {
            throw new RuntimeException("user not found with id: "+ Id);
        }
    }

    public UserEntity deleteUser(String Id){
        Optional<UserEntity> user = userRepo.findById(Id);
        if(user.isPresent()){
             userRepo.deleteById(Id);
        }
        return user.orElse(null);
    }
}
