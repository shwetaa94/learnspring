package com.learn.javabackend.repository;

import com.learn.javabackend.entity.UserEntity;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserEntity,String> {

}
