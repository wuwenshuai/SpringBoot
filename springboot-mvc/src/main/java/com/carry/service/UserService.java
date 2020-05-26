package com.carry.service;


import com.carry.Domain.User;
import com.carry.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }

    @Transactional
    public int inserUser(String name, Integer id) {
        int insert = userMapper.insert(name, id);

        int a = 1/0;
        return insert;
    }
}
