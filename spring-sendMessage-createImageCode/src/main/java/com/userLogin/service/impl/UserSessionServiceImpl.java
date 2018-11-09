package com.userLogin.service.impl;
// Created by ZhangJian on 18/3/7.

import com.userLogin.dao.UserSessionMapper;
import com.userLogin.entity.UserSession;
import com.userLogin.service.UserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionServiceImpl implements UserSessionService{
    @Autowired
    UserSessionMapper userSessionMapper;

    @Override
    public Integer findSessionIdService(UserSession userSession) {
        return userSessionMapper.findSessionId(userSession);
    }

    @Override
    public Integer insertSessionService(UserSession userSession) {
        return userSessionMapper.insertSession(userSession);
    }

    @Override
    public Integer updateSessionService(UserSession userSession) {
        return userSessionMapper.updateSession(userSession);
    }

    @Override
    public String getSessionImgVerifyCodeService(UserSession userSession) {
        return userSessionMapper.getSessionImgVerifyCode(userSession);
    }
}
