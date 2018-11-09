package com.service;

import com.entity.User;

import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-14
 */

public interface UserService {
    User selectByPrimaryKey(int id);
    User selectByPrimaryKey2(int id);

    Integer insertUser(User user);

    List<User> selectAllUser();
}
