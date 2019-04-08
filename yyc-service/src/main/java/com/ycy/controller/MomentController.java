package com.ycy.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.ycy.domain.Moment;
import com.ycy.domain.Plat;
import com.ycy.domain.User;
import com.ycy.domain.UserStar;
import com.ycy.mapper.MomentMapper;
import com.ycy.mapper.PlatMapper;
import com.ycy.mapper.UserMapper;
import com.ycy.mapper.UserStarMapper;
import com.ycy.service.StarServiceImpl;
import com.ycy.service.UserServiceImpl;
import com.ycy.util.CookieUtils;
import com.ycy.util.ResultMessage;


@RestController
@Api(value = "/", description = "用户发布状态服务（小黄包）")
public class MomentController {
		
	@Autowired
	MomentMapper momentMapper;
	@Autowired
	UserStarMapper userStarMapper;
	
	@Autowired
	StarServiceImpl  starService;
	
	/**
	 * 发布小黄包
	 * @param moment
	 * @return
	 */
	@RequestMapping(value="/addMoment",method={RequestMethod.POST})
	@ApiOperation(value = "发布小黄包", response = Moment.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回发布结果信息") })
    public ResultMessage addMoment(@RequestBody  @ApiParam(value = "先上传调用获取图片的url服务；图片之间以封号分隔", required = true) Moment moment,HttpServletRequest request) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			moment.setUser_id(Long.valueOf(userid));
			moment.setCreate_date(new Date());
			int insertByUser = momentMapper.insertMoment(moment);
			if(insertByUser==1) {
				return ResultMessage.createSuccessMessage("发布成功！", null);
			}
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
		return null;
    }
	/**
	 * 最新发布
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping(value="/showMomentNews",method={RequestMethod.GET})
	@ApiOperation(value = "用户展示最新发布", response = Moment.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
	public ResultMessage showMomentNews(HttpServletRequest request) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			int size=10;
			List<Moment> findMomentByMomentIdDesc = momentMapper.findMomentByMomentIdDesc(size);
			List<UserStar> list = userStarMapper.findByUserId(Long.valueOf(userid));
			HashSet<Long> set=new HashSet<Long>();
			for (UserStar userStar : list) {
				set.add(userStar.getMoment_id());
			}
			for (Moment moment : findMomentByMomentIdDesc) {
				if(set.contains(moment.getMoment_id())) moment.setIsStarBySelf(true);
			}
			
			return ResultMessage.createSuccessMessage(findMomentByMomentIdDesc, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
		
	}
	/**
	 * 我的收藏
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/showMomentStar",method={RequestMethod.GET})
	@ApiOperation(value = " 我的收藏", response = Moment.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
	public ResultMessage showMomentStar(HttpServletRequest request) {
		
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			List<Long> momentids=new ArrayList<Long>();
			List<UserStar> list = userStarMapper.findByUserId(Long.valueOf(userid));
			if(list.size()==0)  return ResultMessage.createSuccessMessage(null, null);
			for (UserStar userStar : list) {
				momentids.add(userStar.getMoment_id());
			}
			List<Moment> list2 = momentMapper.findMomentByMomentIds(momentids);
			for (Moment moment : list2) {
				 moment.setIsStarBySelf(true);
			}
			return ResultMessage.createSuccessMessage(list2, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
		
	}
	
	/**
	 * 我的发布
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/showMomentSelf",method={RequestMethod.GET})
	@ApiOperation(value = " 我的发布", response = Moment.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
	public ResultMessage showMomentSelf(HttpServletRequest request) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			List<Moment> list2 = momentMapper.findByUserId(Long.valueOf(userid));
			return ResultMessage.createSuccessMessage(list2, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
	}
	
	/**
	 * 收藏榜单
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/showMomentStarTop10",method={RequestMethod.GET})
	@ApiOperation(value = " 收藏榜单top10", response = Moment.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
	public ResultMessage showMomentStarTop10(HttpServletRequest request) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			List<Moment> list2 = momentMapper.findMomentByStarNumberDesc(10);
			List<UserStar> list = userStarMapper.findByUserId(Long.valueOf(userid));
			HashSet<Long> set=new HashSet<Long>();
			for (UserStar userStar : list) {
				set.add(userStar.getMoment_id());
			}
			for (Moment moment : list2) {
				if(set.contains(moment.getMoment_id())) moment.setIsStarBySelf(true);
			}
			return ResultMessage.createSuccessMessage(list2, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
	}
	
	/**
	 * 用户点击收藏
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/addStar",method={RequestMethod.GET})
	@ApiOperation(value = "用户点击收藏", response = Moment.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
	public ResultMessage addStar(Long moment_id,HttpServletRequest request) {
		try {
				String userid=CookieUtils.getUserIdcookie(request);
				if(userid==null){
					return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
				}
			String addStar = starService.addStar(Long.valueOf(userid),moment_id);
			return ResultMessage.createSuccessMessage(addStar, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
	}
	
	/**
	 * 用户取消收藏
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/cancelStar",method={RequestMethod.GET})
	@ApiOperation(value = "用户取消收藏", response = Moment.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "返回成功或者失败") })
	public ResultMessage cancelStar(Long moment_id,HttpServletRequest request) {
		try {
			String userid=CookieUtils.getUserIdcookie(request);
			if(userid==null){
				return new ResultMessage(ResultMessage.PARAMMISS, "没有userid", null);
			}
			String addStar = starService.cancelStar(Long.valueOf(userid),moment_id);
			return ResultMessage.createSuccessMessage(addStar, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
	}
	
	
}
