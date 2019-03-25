package com.ycy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycy.domain.Moment;
import com.ycy.domain.UserStar;


@Mapper
public interface UserStarMapper {
		
	@Select("SELECT * FROM t_user_star WHERE user_id = #{userid}")
	List<UserStar>  findByUserId (Long userid );
	
	@Insert("INSERT INTO t_user_star(user_id, moment_id) VALUES(#{user_id}, #{moment_id})")
	int insert(UserStar star);
	    
}
