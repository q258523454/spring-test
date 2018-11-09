package com.service;

import com.entity.User;
import com.entity.UserFastJsonSerializer;

import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-14
 */

public interface UserFastJsonSerializerService {
    UserFastJsonSerializer selectByPrimaryKey(int id);
    UserFastJsonSerializer selectByPrimaryKey2(int id);

    Integer insertUser(UserFastJsonSerializer user);

    List<UserFastJsonSerializer> selectAllUser();
}
