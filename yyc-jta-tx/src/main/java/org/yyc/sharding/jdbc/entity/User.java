package org.yyc.sharding.jdbc.entity;

import lombok.Data;

/**
 * @Auther: Tinko
 * @Date: 2018/12/19 16:15
 * @Description:
 */
@Data
public class User {

    private Long id;
    private Long order_id;
    private Long user_id;
    private String userName;
    private String passWord;
    private String nickName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
    
    
    
}