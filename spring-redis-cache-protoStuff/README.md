# RedisCacheTest
Spring redis RedisCache 两种序列化方式测试 <br />
RedisCacheMulti中包括了两种序列化方式 proto stuff 和 java原始序列方式<br />

准备:<br />
CREATE TABLE `user` (<br />
  `id` int(11) NOT NULL AUTO_INCREMENT,<br />
  `name` varchar(255) DEFAULT NULL COMMENT 'name',<br />
  `age` int(11) DEFAULT NULL COMMENT 'age',<br />
  PRIMARY KEY (`id`)<br />
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8<br />
<br />
启动：<br />
步骤1：web.xml修改下面的test或者dev, 分别对应test配置和dev配置<br />
      classpath*:spring/test/spring-*.xml<br />

 步骤2：修改对应文件的配置<br />
        假如选择是test,只需要修改properties/test 下对应的数据库和redis配置
        
        
 
