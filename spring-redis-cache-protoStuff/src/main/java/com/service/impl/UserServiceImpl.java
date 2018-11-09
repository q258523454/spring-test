package com.service.impl;

import com.dao.UserMapper;
import com.entity.User;
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
    private UserMapper userMapper;

    @Autowired
    private RedisCacheMulti redisCacheMulti;

    private Logger logger = Logger.getLogger(this.getClass());


    @Override
    public User selectUserByIdOrg(int id) {
        String cache_key = RedisCacheMulti.CAHCENAME + "|getUserOrg";
        User result_cache = (User) redisCacheMulti.getCacheOrg(cache_key);
        if (result_cache == null) {
            result_cache = userMapper.selectByPrimaryKey(id);
            redisCacheMulti.putCacheOrg(cache_key, result_cache);
            logger.info("put cache with key:" + cache_key);
        } else {
            logger.info("get cache with key:" + cache_key);
        }
        return result_cache;
    }


    @Override
    public List<User> selectAllUserOrg() {
        String cache_key = RedisCacheMulti.CAHCENAME + "|getUserListOrg";
        //先去缓存中取
        List<User> result_cache = (List<User>) redisCacheMulti.getListCacheOrg(cache_key);
        if (result_cache == null) {
            //缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
            result_cache = userMapper.selectAllUser();
            redisCacheMulti.putListCacheOrg(cache_key, result_cache);
            logger.info("put cache with key:" + cache_key);
        } else {
            logger.info("get cache with key:" + cache_key);
        }
        return result_cache;
    }


    @Override
    public User selectUserByIdPro(int id) {
        String cache_key = RedisCacheMulti.CAHCENAME + "|getUserPro";
        //先去缓存中取
        User result_cache = redisCacheMulti.getCachePro(cache_key, User.class);
        if (result_cache == null) {
            //缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
            result_cache = userMapper.selectByPrimaryKey(id);
            redisCacheMulti.putCacheProWithExpireTime(cache_key, result_cache, RedisCacheMulti.CAHCETIME);
            logger.info("put cache with key:" + cache_key);
        } else {
            logger.info("get cache with key:" + cache_key);
        }
        return result_cache;
    }


    @Override
    public List<User> selectAllUserPro() {
        String cache_key = RedisCacheMulti.CAHCENAME + "|getUserListPro";
        //先去缓存中取
        List<User> result_cache = redisCacheMulti.getListCachePro(cache_key, User.class);
        if (result_cache == null) {
            //缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
            result_cache = userMapper.selectAllUser();
            redisCacheMulti.putListCacheProWithExpireTime(cache_key, result_cache, RedisCacheMulti.CAHCETIME);
            logger.info("put cache with key:" + cache_key);
        } else {
            logger.info("get cache with key:" + cache_key);
        }
        return result_cache;
    }
}