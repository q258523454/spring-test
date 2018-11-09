package com.service.impl;

import com.dao.UserFastJsonSerializerMapper;
import com.dao.UserMapper;
import com.entity.UserFastJsonSerializer;
import com.service.UserFastJsonSerializerService;
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
public class UserFastJsonSerializerServiceImpl implements UserFastJsonSerializerService {

    @Autowired
    private UserFastJsonSerializerMapper userFastJsonSerializerMapper;

    @Override
    public UserFastJsonSerializer selectByPrimaryKey(int id) {
        return userFastJsonSerializerMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserFastJsonSerializer selectByPrimaryKey2(int id) {
        return userFastJsonSerializerMapper.selectByPrimaryKey2(id);
    }

    @Override
    public Integer insertUser(UserFastJsonSerializer user) {
        return userFastJsonSerializerMapper.insertUser(user);
    }

    @Override
    public List<UserFastJsonSerializer> selectAllUser() {
        return userFastJsonSerializerMapper.selectAllUser();
    }
}
