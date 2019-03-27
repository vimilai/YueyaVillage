package com.ycy.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.ycy.util.CookieUtils;
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
	@ApiOperation(value = "用户注册", response = ResultMessage.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回用户信息") })
    public ResultMessage add(@RequestBody  @ApiParam(value = "user 对象 openid、picurl、name 一定要传", required = true) User user,HttpServletRequest request,
    		HttpServletResponse response) {
		try {
			if(user.getOpenid()==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有openid", null);
			}
			if(user.getName()==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有昵称", null);
			}
			if(user.getPicurl()==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有用户头像", null);
			}
			
			User user2 = userMapper.findUserByOpenId(user.getOpenid());
			if(user2==null) {
				int insertByUser = userMapper.insertByUser(user);
				user2 = userMapper.findUserByOpenId(user.getOpenid());
				 if(insertByUser==1) {
					 	Cookie cookie = new Cookie("userid", user2.getUser_id()+"");
						response.addCookie(cookie);
						return ResultMessage.createSuccessMessage("用户添加成功", null);
				}
			}else {
				user2.setName(user.getName());
				user2.setPicurl(user.getPicurl());
				userMapper.update(user2);
				Cookie cookie = new Cookie("userid", user2.getUser_id()+"");
				response.addCookie(cookie);
				return ResultMessage.createSuccessMessage("用户修改信息成功", null);
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
	public ResultMessage selectPlat(Long platid,HttpServletRequest request) {
		
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			return  userService.selectPlat(Long.valueOf(userid), platid);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
		
	}
	private String getUserIdcookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("userid".equals(cookie.getName())){
				return cookie.getValue();
			}
		}
		return null;
	}
	
	
}
