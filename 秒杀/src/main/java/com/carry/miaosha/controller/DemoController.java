package com.carry.miaosha.controller;


import com.carry.miaosha.dao.UserMapper;
import com.carry.miaosha.domain.User;
import com.carry.miaosha.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    //1.rest api json输出 2.页面
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello() {
        return Result.success("hello,imooc");
    }

    @RequestMapping("/html")
    public String html(Model model) {
        List<User> allUser = userMapper.findAllUser();
        model.addAttribute("name", allUser);
        return "hello";
    }
}
