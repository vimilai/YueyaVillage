package com.ycy.domain;

import java.util.Date;

public class Moment {
		private long moment_id;
		
		private long user_id;
		private String content;//状态内容
		private String imgurl; //以封号分隔
		private long star_number; //被收藏数
		private Date create_date; //发布时间
		private Boolean isStarBySelf=false; //是否被当前用户收藏
		
		
		public Date getCreate_date() {
			return create_date;
		}
		public void setCreate_date(Date create_date) {
			this.create_date = create_date;
		}
		public long getUser_id() {
			return user_id;
		}
		public void setUser_id(long user_id) {
			this.user_id = user_id;
		}
		public Boolean getIsStarBySelf() {
			return isStarBySelf;
		}
		public void setIsStarBySelf(Boolean isStarBySelf) {
			this.isStarBySelf = isStarBySelf;
		}
		
		public long getMoment_id() {
			return moment_id;
		}
		public void setMoment_id(long moment_id) {
			this.moment_id = moment_id;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getImgurl() {
			return imgurl;
		}
		public void setImgurl(String imgurl) {
			this.imgurl = imgurl;
		}
		public long getStar_number() {
			return star_number;
		}
		public void setStar_number(long star_number) {
			this.star_number = star_number;
		}
		
		
		
}
