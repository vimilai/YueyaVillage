package org.yyc.sharding.jdbc.mapper2;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.yyc.sharding.jdbc.entity.TUser;
@Mapper
public interface  TUserMapper {
	
	@Insert( "INSERT INTO  t_user (name,password,phone,openid)   VALUES  (#{name},#{password},#{phone}, #{openid})")
	void insert(TUser user);
	
	@Select ("select * from t_user")
	List<TUser> selectList();
}
