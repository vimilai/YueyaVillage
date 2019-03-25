package com.ycy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ycy.domain.Plat;
import com.ycy.domain.User;
import com.ycy.mapper.PlatMapper;
import com.ycy.mapper.UserMapper;
import com.ycy.service.UserServiceImpl;
import com.ycy.util.ResultMessage;


@RestController
@Api(value = "/", description = "用户服务")
public class UserController {
		
	@Autowired
	UserMapper userMapper;
	@Autowired
	PlatMapper platMapper;
	@Autowired
	UserServiceImpl userService;
	
	/**
	 * 添加用户，返回用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/adduser",method={RequestMethod.POST})
	@ApiOperation(value = "用户注册", response = User.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回用户信息") })
    public ResultMessage add(@RequestBody  @ApiParam(value = "user 对象 openid 一定要传", required = true) User user) {
		try {
			int insertByUser = userMapper.insertByUser(user);
			User user2 = userMapper.findUserByOpenId(user.getOpenid());
			if(insertByUser==1) {
				return ResultMessage.createSuccessMessage(user2, null);
			}
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
		return null;
    }
	/**
	 * 用户选择平台
	 * @param userid
	 * @param platid
	 * @return
	 */
	@RequestMapping(value="/selectPlat",method={RequestMethod.GET})
	@ApiOperation(value = "用户选择平台", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
	public ResultMessage selectPlat(Long userid,Long platid) {
		try {
			String result = userService.selectPlat(userid, platid);
			return ResultMessage.createSuccessMessage(result, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
		
	}
	
	
}
