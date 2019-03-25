package com.ycy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycy.domain.Moment;


@Mapper
public interface MomentMapper {
		
		@Select("SELECT * FROM t_moment WHERE user_id = #{userid}")
		List<Moment>  findByUserId (Long userid );
		
		@Select("SELECT * FROM t_moment WHERE moment_id = #{momentid}")
		Moment  findByMomentId (Long momentid );
		
		@Update("UPDATE t_moment SET star_number=#{star_number}  WHERE moment_id = #{moment_id}")
		void updateMomentStarNumber(Moment Moment);  
		
		@Insert("INSERT INTO t_moment(user_id, content, imgurl) VALUES(#{user_id}, #{content}, #{imgurl})")
		int insertMoment(Moment moment );
		/**
		 * 根据momentids 查找对应的说说
		 * @return
		 */
		 @Select("<script>"
				 + "SELECT * FROM t_moment WHERE moment_id IN "
				 	+ "<foreach item='item' index='index' collection='ids' open='(' separator=',' close=')'>"
				                  + "#{item}"
				      + "</foreach>"
				 + "</script>")
		List<Moment> findMomentByMomentIds(List<Long> ids);
		
		/**
		 * 收藏榜单排序
		 * @return
		 */
		@Select("SELECT * FROM t_moment order by star_number desc limit #{size}")
		List<Moment> findMomentByStarNumberDesc(int size);
		
		/**
		 * 最新发布
		 * @return
		 */
		@Select("SELECT * FROM t_moment order by moment_id desc limit #{size}")
		List<Moment> findMomentByMomentIdDesc(int size);
	    
}
