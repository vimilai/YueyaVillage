package com.ycy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ycy.domain.User;
import com.ycy.mapper.UserMapper;
import com.ycy.service.StarServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemo2ApplicationTests {
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	StarServiceImpl  starService;

	@Test
	@Transactional
	public void test(){

		userMapper.insert("张三", "123456", "18600000000");
		int a = 1/0;
		userMapper.insert("李四", "123456", "13500000000");
		User u = userMapper.findUserByPhone("12345678910");
		Assert.assertEquals("winterchen", u.getName());
	}


	@Test
	@Transactional
	public void test2(){
		starService.addStar(1L, 1L);
		starService.cancelStar(1L, 1L);


	}

	@Test
	@Transactional
	public void test3(){
		userMapper.insert("张三", "123456", "18600000000");

		User u = userMapper.findUserByPhone("18600000000");

		Assert.assertEquals("123456", u.getPassword());

		u.setName("赵六");
		u.setPassword("12312312");
		userMapper.update(u);

		u = userMapper.findUserByPhone("18600000000");

		List<User> us = userMapper.findAll();

		Assert.assertEquals("12312312", u.getPassword());


		u = userMapper.findUserByPhone("18600000000");

		Assert.assertEquals(null, u);


	}

	@Test
	@Transactional
	public void test4(){
		userMapper.insert("张三", "123456", "18600000000");
		userMapper.insert("李四", "123456", "13500000000");

		List<User> list = userMapper.findAll();


		Assert.assertEquals(2, list.size());

	}

}
