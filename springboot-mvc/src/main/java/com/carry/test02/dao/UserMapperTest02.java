package com.carry.test02.dao;

import com.carry.Domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapperTest02 {
    @Select("select * from user")
    List<User> findAllUser();

    @Insert("INSERT INTO USER(name, id) VALUES(#{name}, #{id})")
    int insert(@Param("name") String name, @Param("id") Integer id);
}
