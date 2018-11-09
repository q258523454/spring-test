package com.service;

import com.entity.User;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-30
 */

public interface UserService {
    public User selectByPrimaryKey(Integer id);

    public User selectMaxKeyUser();

    public User insertSelective(User user);

    public Integer deleteByPrimaryKey(Integer id);
}
