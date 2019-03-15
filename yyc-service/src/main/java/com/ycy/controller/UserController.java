package com.ycy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ycy.domain.User;
import com.ycy.mapper.UserMapper;


@RestController
public class UserController {
		
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("/user")
    public User home(@RequestParam(value = "phone") String phone) {
        return userMapper.findUserByPhone(phone);
    }
	
}
