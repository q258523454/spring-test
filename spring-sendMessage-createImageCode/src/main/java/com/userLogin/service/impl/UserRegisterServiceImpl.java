package com.userLogin.service.impl;
// Created by ZhangJian on 18/3/2.

import com.userLogin.dao.UserRegisterMapper;
import com.userLogin.entity.UserRegister;
import com.userLogin.service.UserRegisterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    UserRegisterMapper userRegisterMapper;
    private Logger logger = Logger.getLogger(UserRegisterServiceImpl.class);

    @Transactional
    public List<UserRegister> findAllUsers() {
        return userRegisterMapper.selectAllUsers();
    }

    public List<String> findAllUserName() {
        return userRegisterMapper.selectAllUserName();
    }

    @Override
    public Integer findUserName(String username) {
        return userRegisterMapper.findUserName(username);
    }
}
