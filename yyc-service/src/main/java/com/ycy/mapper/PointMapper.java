package com.ycy.mapper;


import java.util.List;

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
	    
	    @Insert("INSERT INTO T_point(user_id, plat_id, point) VALUES(#{user_id}, #{plat_id}, #{point})")
	    int insertPoint(Point point);   
	    
	    @Select("select t.rank from (SELECT user_id, @curRank := @curRank + 1 AS rank FROM t_point p, (SELECT @curRank := 0) q ORDER BY point DESC) t where t.user_id=#{user_id}")
	    Integer  findByUSerSortRank (Long userid );
	    
	    @Select("SELECT * FROM T_point order by point desc limit #{size}")
		List<Point> getRankTop10(int size);
	    
}
