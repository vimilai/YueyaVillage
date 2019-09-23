package org.yyc.sharding.jdbc.service;

import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yyc.sharding.jdbc.entity.TUser;
import org.yyc.sharding.jdbc.entity.User;
import org.yyc.sharding.jdbc.mapper.UserMapper;
import org.yyc.sharding.jdbc.mapper2.TUserMapper;
@Slf4j
@Service
public class UserService {
	  	@Resource
	    private UserMapper userMapper;
	  	
		@Resource
	    private TUserMapper tUserMapper;
		
		@Transactional("transactionManager")
	    public void insert(User user1) throws RuntimeException {
			if(true){
				 userMapper.insert(user1);
			}
	        TUser user=new TUser();
	        user.setName("test");
	        user.setPassword("121");
	        user.setOpenid("1111");
	        user.setPhone("1111111");
	        tUserMapper.insert(user);
	    }
	    public List<User> selectList(){
	    	return userMapper.selectList();
	    }
}
