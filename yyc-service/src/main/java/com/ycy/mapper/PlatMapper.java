package com.ycy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycy.domain.Plat;


@Mapper
public interface PlatMapper {
			  /*  @Results({
		    @Result(property = "name", column = "NAME"),
		    @Result(property = "password", column = "PASSWORD"),
		    @Result(property = "phone", column = "PHONE")
		})*/
		@Select("SELECT* FROM T_plat")
		List<Plat> findAll();
		
		@Select("SELECT * FROM T_plat WHERE plat_id = #{plat_id}")
		Plat  findByPlatId (Long plat_id );
		
		@Update("UPDATE T_plat SET plat_person=#{plat_person}  WHERE plat_id = #{plat_id}")
		void updatePlatPerson(Plat plat);  

	    
}
