package com.ycy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ycy.domain.Plat;
import com.ycy.domain.User;
import com.ycy.mapper.PlatMapper;
import com.ycy.mapper.UserMapper;
import com.ycy.util.ResultMessage;


@RestController
public class PlatController {
		
	@Autowired
	PlatMapper platMapper;
	@Autowired
	UserMapper userMapper;
	
	
	@RequestMapping(value="/getPlatAll",method={RequestMethod.GET})
    public ResultMessage home() {
		try {
				List<Plat> findAll = platMapper.findAll();
				return ResultMessage.createSuccessMessage(findAll, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	
	

	
	
}
