package com.ycy.domain;

public class User {
	  	private Long user_id;
	    private String name;
	    private String password;
	    private String phone;
	    private String openid;
	    private Long plat_id;
	    
		public Long getPlat_id() {
			return plat_id;
		}
		public void setPlat_id(Long plat_id) {
			this.plat_id = plat_id;
		}
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
	    
	    
}
