package com.ycy.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycy.domain.Point;


@Mapper
public interface PointMapper {
	   @Select("SELECT * FROM T_point WHERE plat_id = #{plat_id}")
	    Point  findByPlatId (Long userid );
	    
	    @Update("UPDATE T_point SET point=#{point}  WHERE point_id = #{point_id}")
	    void updatePlatPerson(Point point);  
	    
	    @Insert("INSERT INTO T_point(user_id, palt_id, point) VALUES(#{user_id}, #{palt_id}, #{point})")
	    int insertPoint(Point point);   
	    
}
