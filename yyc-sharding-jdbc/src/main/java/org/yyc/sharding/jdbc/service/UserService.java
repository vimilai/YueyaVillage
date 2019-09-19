package org.yyc.sharding.jdbc.service;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.yyc.sharding.jdbc.entity.User;
import org.yyc.sharding.jdbc.mapper.UserMapper;
@Slf4j
@Service
public class UserService {
	  	@Resource
	    private UserMapper userMapper;

	    public void insert(User user) {
	        userMapper.insert(user);
	    }
}
