package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.User;
import com.eduhub.eduhub_backend.component.UserService;

import com.eduhub.eduhub_backend.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAll(){

        return ResponseEntity.ok(
                userService.getAllUsers());
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(
            @PathVariable String userId){

        if(!userId.matches("[a-zA-Z0-9]+")){

            throw new IllegalArgumentException(
                    "Special characters not allowed");
        }

        User user =
                userService
                        .findUser(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User",
                                        "userId",
                                        userId));

        return ResponseEntity.ok(user);
    }


    @GetMapping("/search")
    public ResponseEntity<User> search(
            @RequestParam String id){

        User user =
                userService
                        .findUser(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "User",
                                        "userId",
                                        id));

        return ResponseEntity.ok(user);
    }


    @PostMapping
    public ResponseEntity<User> create(
            @RequestBody User user){

        return ResponseEntity.ok(
                userService.addUser(user));
    }


    @PutMapping("/{userId}")
    public ResponseEntity<User> updatePassword(

            @PathVariable String userId,

            @RequestParam String password){

        return ResponseEntity.ok(
                userService.updatePassword(
                        userId,
                        password));
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(

            @PathVariable String userId){

        return ResponseEntity.ok(
                userService.deleteUser(
                        userId));
    }
}