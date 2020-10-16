package com.javatechie.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javatechie.jwt.api.entity.User;
import com.javatechie.jwt.api.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUser() {
		List<User> users = Stream.of(new User(101, "javatechie", "password", "javatechie@gmail.com"),
				new User(102, "ajit", "ajit", "ajite@gmail.com"), new User(103, "abc", "abc", "abc@gmail.com"),
				new User(104, "XYZ", "xyz", "xyz@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(users); 

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
