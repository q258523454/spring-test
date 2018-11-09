package com.service;

import com.entity.User;
import com.entity.User2;

import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-14
 */

public interface User2Service {
    User2 selectByPrimaryKey(int id);

    Integer insertUser(User2 user);

    List<User2> selectAllUser();
}
