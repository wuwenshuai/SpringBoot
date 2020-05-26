package com.carry.controller;

import com.carry.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SynController {

    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping
    public String syn() {
        System.out.println(1);
        String s = sendEmailService.sendEmail();
        System.out.println(3);
        return "result:"+s;
    }
}
