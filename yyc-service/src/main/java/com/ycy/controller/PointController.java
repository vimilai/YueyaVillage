package com.ycy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycy.service.PointServiceImpl;
import com.ycy.util.CookieUtils;
import com.ycy.util.ResultMessage;


@RestController
@Api(value = "/", description = "积分服务")
public class PointController {
		
	@Autowired
	PointServiceImpl pointService;
	/**
	 * 用户上传积分
	 * @return
	 */
	@RequestMapping(value="/addpoint",method={RequestMethod.GET})
	@ApiOperation(value = "用户上传积分", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
    public ResultMessage home(HttpServletRequest request,String point) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
				String string = pointService.addPoint(Long.valueOf(userid),Long.valueOf( point));
				return ResultMessage.createSuccessMessage(string, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	
	/**
	 * 用户查看自己当前排名
	 * @return
	 */
	@RequestMapping(value="/getRankSelf",method={RequestMethod.GET})
	@ApiOperation(value = "用户查看自己当前排名", response = String.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回自己的排名") })
    public ResultMessage getRankSelf(HttpServletRequest request) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
				Long valueOf = Long.valueOf(userid);
				Integer string = pointService.getRankSelf(valueOf);
				return ResultMessage.createSuccessMessage(string, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	/**
	 * 用户查看前10排名
	 * @return
	 */
	@RequestMapping(value="/getRankTop10",method={RequestMethod.GET})
	@ApiOperation(value = "用户查看前10排名", response =  List.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回自己的排名 包含用户以及积分信息") })
    public ResultMessage getRankTop10() {
		try {
				 List<Map<String, Object>> rankTop10 = pointService.getRankTop10();
				return ResultMessage.createSuccessMessage(rankTop10, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	
	
}
