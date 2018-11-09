

-- 用户注册表
CREATE TABLE `user_register` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(100) DEFAULT NULL COMMENT '电话号码',
  `code` varchar(100) DEFAULT '' COMMENT 'code',
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert into `zhang`.`user_register` ( `password`, `age`, `code`, `username`, `telephone`, `name`) values ( '2', '18', '', '3', null, 'zhangxiaofan');
insert into `zhang`.`user_register` ( `password`, `age`, `code`, `username`, `telephone`, `name`) values ( '2', '19', '', '1', null, 'caocao');
insert into `zhang`.`user_register` ( `password`, `age`, `code`, `username`, `telephone`, `name`) values ( '123', '20', '', 'zhang', null, 'zhang');

-- session 验证码
CREATE TABLE `user_session_table` (
  `session_id` varchar(50) NOT NULL,
  `session_code` varchar(50) DEFAULT NULL,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;