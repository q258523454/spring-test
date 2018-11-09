package com.service.impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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

    // 首先在缓存中查找，如果没有执行方法并缓存结果，然后返回数据
    @Cacheable(value = "mySringCache", key = "'id_'+#id")
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    // 这个必须要查数据库
    public User selectMaxKeyUser() {
        return userMapper.selectMaxKeyUser();
    }

    // 先执行方法，然后将返回值放回缓存。可以用作缓存的更新
    @CachePut(value = "mySringCache", key = "'id_'+#user.getId()")
    public User insertSelective(User user) {
        // useGeneratedKeys="true", 下面的 user.id 按照数据递增
        Integer res = userMapper.insertUser(user);
        if (null != res) {
            return user;
        } else {
            return null;
        }
    }

    // 注解上的参数, 就是方法内的参数, 只是加上#号
    @CacheEvict(value = "mySringCache", key = "'id_'+#id")
    public Integer deleteByPrimaryKey(Integer id) {
        return userMapper.delUserById(id);
    }
}