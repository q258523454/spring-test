package com.service.impl;

import com.dao.MyUserMapper;
import com.entity.MyUser;
import com.service.UserService;
import com.util.RedisCacheMulti;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-30
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyUserMapper userMapper;

    @Autowired
    private RedisCacheMulti redisCacheMulti;

    private Logger logger = Logger.getLogger(this.getClass());


    @Override
    public List<MyUser> selectAllUserOrg() {
        String cache_key = RedisCacheMulti.CAHCENAME + "|getUserListOrg";
        //先去缓存中取
        List<MyUser> result_cache = (List<MyUser>) redisCacheMulti.getListCacheOrg(cache_key);
        if (result_cache == null) {
            result_cache = userMapper.selectAllUser();
            redisCacheMulti.putListCacheOrg(cache_key, result_cache);
            logger.info("put cache with key:" + cache_key);
        } else {
            logger.info("get cache with key:" + cache_key);
        }
        return result_cache;
    }


    @Override
    public List<MyUser> selectAllUserPro() {
        String cache_key = RedisCacheMulti.CAHCENAME + "|getUserListPro";
        //先去缓存中取
        List<MyUser> result_cache = redisCacheMulti.getListCachePro(cache_key, MyUser.class);
        if (result_cache == null) {
            //缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
            result_cache = userMapper.selectAllUser();
            redisCacheMulti.putListCacheProWithExpireTime(cache_key, result_cache, RedisCacheMulti.CAHCETIME);
            logger.info("缓存不存在,添加. put cache with key:" + cache_key);
        } else {
            logger.info("缓存已存在,查询. get cache with key:" + cache_key);
        }
        return result_cache;
    }
}