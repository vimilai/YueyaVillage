package com.ycy.domain;

import java.util.Date;

public class Wish {
	private Long wish_id;
	private Long user_id;
	private String content;
	private String look_flag;
	private Date create_date;
	public Long getWish_id() {
		return wish_id;
	}
	public void setWish_id(Long wish_id) {
		this.wish_id = wish_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLook_flag() {
		return look_flag;
	}
	public void setLook_flag(String look_flag) {
		this.look_flag = look_flag;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
}
