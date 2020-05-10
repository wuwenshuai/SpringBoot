package com.carry.redis.test;


import com.carry.redis.service.RedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedisController {

    @Autowired
    private RedisTemplateService redisTemplateService;

    @GetMapping("/stock")
    public String setStr() {
        redisTemplateService.set("stock", "50", null);
        return redisTemplateService.getString("hahaha");
    }
}
