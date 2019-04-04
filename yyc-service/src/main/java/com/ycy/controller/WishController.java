package com.ycy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycy.domain.Wish;
import com.ycy.mapper.WishMapper;
import com.ycy.service.PointServiceImpl;
import com.ycy.util.CookieUtils;
import com.ycy.util.ResultMessage;


@RestController
@Api(value = "/", description = "许愿池服务")
public class WishController {
		
	@Autowired
	WishMapper wishMapper;
	/**
	 * 用户上传积分
	 * @return
	 */
	@RequestMapping(value="/addwish",method={RequestMethod.GET})
	@ApiOperation(value = "许愿池发布", response = ResultMessage.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
    public ResultMessage home(HttpServletRequest request,String  content) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			Wish wish=new Wish();
			wish.setCreate_date(new Date());
			wish.setUser_id(Long.valueOf(userid));
			wish.setContent(content);
			wishMapper.insertWish(wish);
			return ResultMessage.createSuccessMessage("发布成功", null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	
	/**
	 * 用户查看自己当前排名
	 * @return
	 */
	@RequestMapping(value="/getWish",method={RequestMethod.GET})
	@ApiOperation(value = "用户查看许愿池", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回自己的排名") })
    public ResultMessage getWish(HttpServletRequest request) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			Wish findWishNoLook = wishMapper.findWishNoLook();
			findWishNoLook.setLook_flag("Y");
			wishMapper.updateLookFlag(findWishNoLook);
			return ResultMessage.createSuccessMessage(findWishNoLook, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	
	
}
