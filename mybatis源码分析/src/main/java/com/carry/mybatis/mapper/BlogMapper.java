package com.carry.mybatis.mapper;

import com.carry.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
  @Select("SELECT * FROM user WHERE id = #{id}")
  User selectBlog(int id);
}