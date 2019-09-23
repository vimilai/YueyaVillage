package org.yyc.sharding.jdbc.service;

import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.yyc.sharding.jdbc.entity.TUser;
import org.yyc.sharding.jdbc.mapper2.TUserMapper;

@Slf4j
@Service("tUserService")
public class TUserService {
	  	@Resource
	    private TUserMapper tUserMapper;

	    public void insert(TUser user) {
	    	tUserMapper.insert(user);
	    }
	    public List<TUser> selectList(){
	    	return tUserMapper.selectList();
	    }
}
