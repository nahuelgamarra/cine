package com.example.cine.controllers;

import com.example.cine.models.User;
import com.example.cine.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return this.userService.findAllUsers();
    }

    @PostMapping()
    public void saveUser(@RequestBody User user){
        this.userService.saveUser(user);
    }
}
