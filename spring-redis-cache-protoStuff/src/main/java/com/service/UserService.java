package com.service;


import com.entity.MyUser;

import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-30
 */

public interface UserService {

    public List<MyUser> selectAllUserPro();

    public List<MyUser> selectAllUserOrg();

}
