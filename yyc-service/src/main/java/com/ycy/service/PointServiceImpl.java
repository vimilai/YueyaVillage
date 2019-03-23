package com.ycy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ycy.domain.Plat;
import com.ycy.domain.Point;
import com.ycy.domain.User;
import com.ycy.mapper.PlatMapper;
import com.ycy.mapper.PointMapper;
import com.ycy.mapper.UserMapper;

@Service
public class PointServiceImpl {
		@Autowired
		PointMapper pointMapper;
		@Autowired
		UserMapper userMapper;
		
		@Autowired
		PlatMapper platMapper;
		
		@Transactional
		public String addPoint(Long userid,Long point) {
			String result="添加成功";
			User user = userMapper.findUserByUserId(userid);
			if(user==null)
				return "没有该用户！";
			//1.更新或者新增积分数据
			Point point2User= pointMapper.findByPlatId(user.getUser_id());
			if(point2User==null) {
				Point newPoint = new Point(user.getUser_id(),user.getPlat_id(),point);
				pointMapper.insertPoint(newPoint);
				
			}else {
				point2User.setPoint(point2User.getPoint()+point);
				pointMapper.updatePlatPerson(point2User);
			}
			//2.更新平台总积分
			Plat plat = platMapper.findByPlatId(user.getPlat_id());
			if(plat==null)
				return "用户数据不对，没有该平台却绑定在用户上";
			plat.setPlat_point(plat.getPlat_point()+point);
			platMapper.updatePlatPerson(plat);
			
			return result;
		}
		
}
