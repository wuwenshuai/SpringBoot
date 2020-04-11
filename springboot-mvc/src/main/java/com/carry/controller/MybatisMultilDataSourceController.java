package com.carry.controller;

import com.carry.test01.service.UserTest01Service;
import com.carry.test02.service.UserTest02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisMultilDataSourceController {
	@Autowired
	private UserTest01Service userServiceTest01;
	@Autowired
	private UserTest02Service userServiceTest02;

	@RequestMapping("/insertUserTest1")
	public Integer insertUserTest1() {
		return userServiceTest01.inserUser("111", 111);
	}

	@RequestMapping("/insertUserTest2")
	public Integer insertUserTest2() {
		return userServiceTest02.inserUser("2222", 2222);
	}
}