package com.carry.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {


    @Async //相当于重新开辟个线程执行，使用aop技术，单独创建一个线程执行
    public String sendEmail() {
        try {
            System.out.println("我发消息....");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消息发送完毕...");
        return "1";
    }
}
