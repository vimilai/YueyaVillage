CREATE TABLE `t_user_star` (
  `star_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `moment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`star_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户评论收藏表';