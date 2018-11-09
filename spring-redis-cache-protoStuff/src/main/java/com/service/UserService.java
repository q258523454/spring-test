package com.service;

import com.entity.User;

import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-30
 */

public interface UserService {


    public User selectUserByIdOrg(int id);

    public User selectUserByIdPro(int id);

    public List<User> selectAllUserPro();

    public List<User> selectAllUserOrg();

}
