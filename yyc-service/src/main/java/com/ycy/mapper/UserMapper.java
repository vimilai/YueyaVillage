package com.ycy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ycy.domain.User;


@Mapper
public interface UserMapper {
	 	@Select("SELECT * FROM T_USER WHERE PHONE = #{phone}")
	    User findUserByPhone(@Param("phone") String phone);

	    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
	    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

	    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(" +
	            "#{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{phone, jdbcType=VARCHAR})")
	    int insertByMap(Map<String, Object> map);

	    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE,OPENID) VALUES(#{name}, #{password}, #{phone},#{openid})")
	    int insertByUser(User user);

	    @Update("UPDATE T_USER SET NAME = #{name}, PASSWORD = #{password} WHERE PHONE = #{phone}")
	    void update(User user);

	    @Delete("DELETE FROM T_USER WHERE ID = #{id}")
	    void delete(Integer id);

	    @Results({
	            @Result(property = "name", column = "NAME"),
	            @Result(property = "password", column = "PASSWORD"),
	            @Result(property = "phone", column = "PHONE")
	    })
	    @Select("SELECT NAME, PASSWORD, PHONE FROM T_USER")
	    List<User> findAll();
}
