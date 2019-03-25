package com.ycy.domain;

public class Moment {
		private long moment_id;
		private String content;//状态内容
		private String imgurl; //以封号分隔
		private long star_number; //被收藏数
		
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
