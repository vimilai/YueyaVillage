CREATE TABLE `t_point` (
  `point_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `plat_id` bigint(20) DEFAULT NULL,
  `point` bigint(20) DEFAULT '0' COMMENT '»ý·Ö',
  PRIMARY KEY (`point_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;