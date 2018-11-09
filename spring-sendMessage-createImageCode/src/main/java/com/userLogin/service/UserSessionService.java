package com.userLogin.service;
// Created by ZhangJian on 18/3/7.

import com.userLogin.entity.UserSession;

public interface UserSessionService {
    Integer findSessionIdService(UserSession userSession);

    Integer insertSessionService(UserSession userSession);

    Integer updateSessionService(UserSession userSession);

    String getSessionImgVerifyCodeService(UserSession userSession);


}
