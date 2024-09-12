package com.learn.javabackend.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(value = "user")
@Data
public class UserEntity {
    @Id
    private String id;

    @Indexed(unique = true)
    @NonNull
    private String username;

    @NonNull
    private String password;

    @DBRef
    private List<TodoEntity> todoEntities= new ArrayList<TodoEntity>();

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
