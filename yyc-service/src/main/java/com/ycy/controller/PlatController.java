package com.ycy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
@Api(value = "/", description = "平台服务")
public class PlatController {
		
	@Autowired
	PlatMapper platMapper;
	@Autowired
	UserMapper userMapper;
	
	
	@RequestMapping(value="/getPlatAll",method={RequestMethod.GET})
	@ApiOperation(value = "获取所有平台信息", response =  Plat.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回自己的排名 包含用户以及积分信息") })
    public ResultMessage home() {
		try {
				List<Plat> findAll = platMapper.findAll();
				return ResultMessage.createSuccessMessage(findAll, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	
	

	
	
}
