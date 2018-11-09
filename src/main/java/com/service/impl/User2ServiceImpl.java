package com.service.impl;

import com.dao.User2Mapper;
import com.entity.User2;
import com.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-14
 */

@Service
public class User2ServiceImpl implements User2Service {

    @Autowired
    private User2Mapper user2Mapper;

    @Override
    public User2 selectByPrimaryKey(int id) {
        return user2Mapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer insertUser(User2 user) {
        return user2Mapper.insertUser(user);
    }

    @Override
    public List<User2> selectAllUser() {
        return user2Mapper.selectAllUser();
    }
}
