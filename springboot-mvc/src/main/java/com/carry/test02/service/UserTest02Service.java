package com.carry.test02.service;


import com.carry.Domain.User;
import com.carry.test02.dao.UserMapperTest02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserTest02Service {

    @Autowired
    private UserMapperTest02 userMapper;

    public List<User> getUsers() {
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }

    @Transactional
    public int inserUser(String name, Integer id) {
        int insert = userMapper.insert(name, id);
        return insert;
    }
}
