package com.carry.redis.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDemo1 {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/setString")
    public String setString(String key, String object) {
        stringRedisTemplate.opsForValue().set("test","hehe");
        String test = stringRedisTemplate.opsForValue().get("test");

        stringRedisTemplate.opsForSet().add("haha", "1","3","6","0");
        String haha = stringRedisTemplate.opsForValue().get("haha");
        return haha;
    }



}
