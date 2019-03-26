package com.ycy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycy.domain.Plat;
import com.ycy.domain.User;
import com.ycy.mapper.PlatMapper;
import com.ycy.mapper.UserMapper;
import com.ycy.util.ResultMessage;

@Service
public class UserServiceImpl {
	@Autowired
	UserMapper userMapper;
	@Autowired
	PlatMapper platMapper;
	
	
	@Transactional
	public ResultMessage selectPlat(Long userid,Long platid) {
			
			User user = userMapper.findUserByUserId(userid);
			if(user.getPlat_id().equals(platid)) {
				 return new ResultMessage(ResultMessage.PARAMERROR, "平台跟原先一致，不能修改！", null);
			}
			Plat plat = platMapper.findByPlatId(platid);
			if(plat==null) {
				 return new ResultMessage(ResultMessage.NODATA, "没有该平台！", null);
			}
			//1.更改用户平台
			user.setPlat_id(platid);
			userMapper.update(user);
			//2添加该平台使用人数
			plat.setPlat_person(plat.getPlat_person()+1);
			platMapper.updatePlatPerson(plat);
			return ResultMessage.createSuccessMessage("选择平台成功！", null);
	}
	
}
