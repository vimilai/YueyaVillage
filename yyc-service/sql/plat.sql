CREATE TABLE `t_plat` (
  `plat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plat_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ƽ̨����',
  `plat_person` bigint(40) DEFAULT '0' COMMENT 'ƽ̨ʹ������',
  `plat_point` bigint(40) DEFAULT '0' COMMENT 'ʹ�û���',
  PRIMARY KEY (`plat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;