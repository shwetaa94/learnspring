package com.learn.javabackend.repository;

import com.learn.javabackend.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<UserEntity, String> {

}
