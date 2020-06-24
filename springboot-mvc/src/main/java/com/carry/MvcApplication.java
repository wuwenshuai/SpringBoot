package com.carry;


import com.carry.Domain.User;
import com.carry.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = {"com.carry.dao"})
public class MvcApplication {

    public static void main(String[] args) throws IOException {

        String resource = "org/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.selectOne("xxx");
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> allUser = mapper.findAllUser();
        }
        SpringApplication.run(MvcApplication.class, args);
    }
}
