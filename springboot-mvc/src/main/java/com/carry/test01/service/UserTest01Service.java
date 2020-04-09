package com.carry.test01.service;


import com.carry.Domain.User;
import com.carry.test01.dao.UserMapperTest01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserTest01Service {

    @Autowired
    private UserMapperTest01 userMapper;

    public List<User> getUsers() {
        List<User> allUser = userMapper.findAllUser();
        return allUser;
    }

    //@Transactional(transactionManager = "test2TransactionManager") 需要制定事务管理者
    public int inserUser(String name, Integer id) {
        int insert = userMapper.insert(name, id);
        return insert;
    }
}
