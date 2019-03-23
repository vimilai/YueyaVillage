package com.ycy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycy.service.PointServiceImpl;
import com.ycy.util.ResultMessage;


@RestController
public class PointController {
		
	@Autowired
	PointServiceImpl pointService;
	/**
	 * 用户上传积分
	 * @return
	 */
	@RequestMapping(value="/addpoint",method={RequestMethod.GET})
    public ResultMessage home(String userId,String point) {
		try {
				String string = pointService.addPoint(Long.valueOf(userId),Long.valueOf( point));
				return ResultMessage.createSuccessMessage(string, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
	
	

	
	
}
