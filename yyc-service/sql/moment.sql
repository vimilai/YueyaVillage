CREATE TABLE `t_moment` (
  `moment_id` bigint(40) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '发状态的用户id',
  `content` varchar(4000) DEFAULT NULL COMMENT '文字',
  `imgurl` varchar(4000) DEFAULT NULL COMMENT '图片列表url',
  `star_number` bigint(20) DEFAULT '0' COMMENT '收藏数',
  PRIMARY KEY (`moment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户状态表';