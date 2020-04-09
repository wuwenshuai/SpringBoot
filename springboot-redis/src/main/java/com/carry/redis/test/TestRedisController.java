package com.carry.redis.test;


import com.carry.redis.service.RedisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedisController {

    @Autowired
    private RedisTemplateService redisTemplateService;
    @GetMapping("/strng")
    public String setStr() {
        redisTemplateService.set("hahaha", "hehehe", 10L);
        return redisTemplateService.getString("hahaha");
    }


}
