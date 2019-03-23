package com.ycy.domain;

public class Point {
		private Long	point_id;
		private Long	user_id;
		private Long	plat_id;
		private Long	point;
		
		
		
		
		
		public Point(Long user_id, Long plat_id, Long point) {
			this.user_id = user_id;
			this.plat_id = plat_id;
			this.point = point;
		}
		public Long getPoint_id() {
			return point_id;
		}
		public void setPoint_id(Long point_id) {
			this.point_id = point_id;
		}
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		public Long getPlat_id() {
			return plat_id;
		}
		public void setPlat_id(Long plat_id) {
			this.plat_id = plat_id;
		}
		public Long getPoint() {
			return point;
		}
		public void setPoint(Long point) {
			this.point = point;
		}
		
}
