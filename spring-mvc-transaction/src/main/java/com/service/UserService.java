package com.service;

import com.entity.User;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */
public interface UserService {

    List<User> getUser();

    int insertUser(User user);
}
