package com.example.tutorial.controller;

import com.example.tutorial.dto.UserRegForm;
import com.example.tutorial.service.UserService;
import com.example.tutorial.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity findUserById(@PathVariable Long id) {
        User userByName = userService.findUserById(id);
        return new ResponseEntity<>(userByName, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity findUserByName(@RequestParam String name) {
        User userByName = userService.findUserByName(name);
        return new ResponseEntity<>(userByName, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserRegForm userRegForm) {
        userService.saveUser(userRegForm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
