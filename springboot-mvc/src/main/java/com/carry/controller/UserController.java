package com.carry.controller;


import com.carry.Domain.User;
import com.carry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    List<User> getUsers() {

        Random random = new Random();
        userService.inserUser("ca", random.nextInt(999999999));
        return userService.getUsers();
    }
}
