package com.ycy.domain;
/**
 * 用户收藏
 * @author wanlai
 *
 */
public class UserStar {
		private Long star_id	;
		private Long user_id;//用户id
		private Long moment_id; //收藏的朋友圈id
		public Long getStar_id() {
			return star_id;
		}
		public void setStar_id(Long star_id) {
			this.star_id = star_id;
		}
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		public Long getMoment_id() {
			return moment_id;
		}
		public void setMoment_id(Long moment_id) {
			this.moment_id = moment_id;
		}
		
		
		
}
