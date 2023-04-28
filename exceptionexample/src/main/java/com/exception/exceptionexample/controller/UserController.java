package com.exception.exceptionexample.controller;

import com.exception.exceptionexample.exception.ResourceNotFoundException;
import com.exception.exceptionexample.model.User;
import com.exception.exceptionexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    @Autowired
    UserRepository userRepository;
    //get all user
    @GetMapping
    public List<User> getAllUser(){

        return this.userRepository.findAll();
    }
    //get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id")long id){
        return this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id :" + id));

    }

    //create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    //update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") long id){
        User existingUser=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id :" + id));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return this.userRepository.save(existingUser);
    }
    //delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id")long id){
        User existingUser=this.userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id :" + id));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }

}
