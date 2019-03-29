package com.ycy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycy.domain.Wish;


@Mapper
public interface WishMapper {
		
		@Select("SELECT * FROM t_wish WHERE user_id = #{userid}")
		List<Wish>  findByUserId (Long userid );
		
		@Select("SELECT * FROM t_wish WHERE wish_id = #{wish_id}")
		Wish  findByWishId (Long wish_id );
		
		@Update("UPDATE t_wish SET look_flag=#{look_flag}  WHERE wish_id = #{wish_id}")
		void updateLookFlag(Wish Moment);  
		
		@Select("SELECT * FROM t_wish WHERE look_flag='N' order by create_date limit 1")
		Wish  findWishNoLook ();
		
		@Insert("INSERT INTO t_wish(user_id, content, create_date) VALUES(#{user_id}, #{content}, #{create_date})")
		int insertWish(Wish wish);
		
		/**
		 * 最新发布
		 * @return
		 */
		@Select("SELECT * FROM t_wish order by moment_id desc limit #{size}")
		List<Wish> findMomentByMomentIdDesc(int size);
	    
}
