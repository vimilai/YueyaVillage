package com.ycy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycy.domain.Moment;
import com.ycy.domain.Plat;
import com.ycy.domain.User;
import com.ycy.domain.UserStar;
import com.ycy.mapper.MomentMapper;
import com.ycy.mapper.PlatMapper;
import com.ycy.mapper.UserMapper;
import com.ycy.mapper.UserStarMapper;
import com.ycy.util.ResultMessage;

@Service
public class StarServiceImpl {
	@Autowired
	MomentMapper momentMapper;
	@Autowired
	UserStarMapper userStarMapper;
	
	@Transactional
	public String addStar(Long userid, Long moment_id) {
		//1.用户收藏表 添加一条记录
		UserStar star=new UserStar();
		star.setMoment_id(moment_id);
		star.setUser_id(userid);
		int insert = userStarMapper.insert(star);
		//2.该小黄包添加收藏人数
		synchronized (StarServiceImpl.class) {
			Moment moment = momentMapper.findByMomentId(moment_id);
			moment.setStar_number(moment.getStar_number()+1);
			momentMapper.updateMomentStarNumber(moment);
		}
		return "收藏成功！";
	}
	
	
	
}
