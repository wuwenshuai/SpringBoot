package com.carry.dao;

import com.carry.Domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> findAllUser();
}
