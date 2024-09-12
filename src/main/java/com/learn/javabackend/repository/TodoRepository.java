package com.learn.javabackend.repository;

import com.learn.javabackend.entity.TodoEntity;
import com.learn.javabackend.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoEntity, String> {
    void deleteAllByUser(UserEntity user);
}
