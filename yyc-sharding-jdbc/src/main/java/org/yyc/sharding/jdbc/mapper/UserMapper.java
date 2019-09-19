package org.yyc.sharding.jdbc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.yyc.sharding.jdbc.entity.User;
@Mapper
public interface  UserMapper {
	
	@Insert( "INSERT INTO  t_order (order_id,user_id,userName,passWord)   VALUES  (#{order_id},#{user_id},#{userName}, #{passWord})")
	void insert(User user);
}
