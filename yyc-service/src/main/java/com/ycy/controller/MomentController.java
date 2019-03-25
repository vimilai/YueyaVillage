package com.ycy.controller;

import java.util.ArrayList;
import java.util.List;

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
    public ResultMessage addMoment(@RequestBody  @ApiParam(value = "先上传调用获取图片的url服务", required = true) Moment moment) {
		try {
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
	public ResultMessage showMomentNews() {
		try {
			int size=10;
			List<Moment> findMomentByMomentIdDesc = momentMapper.findMomentByMomentIdDesc(size);
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
	public ResultMessage showMomentStar(Long userid) {
		try {
			List<Long> momentids=new ArrayList<Long>();
			List<UserStar> list = userStarMapper.findByUserId(userid);
			for (UserStar userStar : list) {
				momentids.add(userStar.getMoment_id());
			}
			List<Moment> list2 = momentMapper.findMomentByMomentIds(momentids);
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
	public ResultMessage showMomentSelf(Long userid) {
		try {
			List<Moment> list2 = momentMapper.findByUserId(userid);
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
	public ResultMessage showMomentStarTop10() {
		try {
			List<Moment> list2 = momentMapper.findMomentByStarNumberDesc(10);
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
	public ResultMessage addStar(Long userid,Long moment_id) {
		try {
			
			String addStar = starService.addStar(userid,moment_id);
			return ResultMessage.createSuccessMessage(addStar, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
	}
	
	
	
}
