package com.learn.javabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing // Enable auditing for @CreatedDate and @LastModifiedDate
public class JavabackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavabackendApplication.class, args);
	}

}
