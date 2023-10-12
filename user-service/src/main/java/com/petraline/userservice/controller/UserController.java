package com.petraline.userservice.controller;

import java.time.LocalDate;
import java.sql.Date;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.petraline.userservice.model.User;
import com.petraline.userservice.repository.UserRepository;


@Controller
public class UserController {
    private final UserRepository userRepository;
    
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @QueryMapping
    Iterable<User> users(){
        return userRepository.findAll();
    }

    @MutationMapping
    User addUser(@Argument UserInput user){
        User newUser = new User(user.first_name, user.last_name,  new Date(LocalDate.now().getDayOfMonth()), user.email);
        return userRepository.save(newUser);
    }

    record UserInput(String first_name, String last_name, String email){}
}
