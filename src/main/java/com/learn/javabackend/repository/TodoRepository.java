package com.learn.javabackend.repository;

import com.learn.javabackend.entity.TodoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoEntity, String> {

}
