package com.carry.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${name}")
    private String name;

    @GetMapping("/index")
    public String index() {
        return name;
    }
}
