package com.carry.redis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTemplateService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object value, Long time) {
        //设置string类型的
        if (value instanceof  String) {
            setString(key, value);
        }
        // 设置set类型的
        if (value instanceof Set) {
            setSet(key, value);
        }
        // 设置有效期
        if (time != null) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    public String getString(String key) {
       return stringRedisTemplate.opsForValue().get(key);
    }

    private void setString(String key, Object value) {
        stringRedisTemplate.opsForValue().set(key, (String) value);
    }

    private void setSet(String key, Object value) {
        Set<String> valueSet = (Set<String>) value;
        for (String s : valueSet) {
            stringRedisTemplate.opsForSet().add(key, s);
        }
    }



}
