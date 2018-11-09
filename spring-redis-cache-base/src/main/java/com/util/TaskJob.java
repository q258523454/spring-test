package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-04-03
 */

@Service
public class TaskJob {


    @Autowired
    RedisTemplate redisTemplate;    // 获取redisTemplate(redis缓存)实例

    public void printTaskJob() {
        RedisCache redisCache = new RedisCache();
        redisCache.setRedisTemplate(redisTemplate);     // 初始化自定义RedisCache工具类
        redisCache.setName("mySringCache");             // 名字是数据库注解上要用到的
        System.out.println("定时任务[清空缓存]:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        redisCache.clear();
        System.out.println("定时任务[清空完成]");
    }
}
