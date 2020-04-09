package com.carry.controller;


import com.carry.Domain.User;
import com.carry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    List<User> getUsers() {
        return userService.getUsers();
    }
}
