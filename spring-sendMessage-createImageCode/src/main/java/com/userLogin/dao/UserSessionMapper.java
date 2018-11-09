package com.userLogin.dao;

import com.userLogin.entity.UserSession;

public interface UserSessionMapper {
    Integer findSessionId(UserSession userSession);

    Integer insertSession(UserSession userSession);

    Integer updateSession(UserSession userSession);

    String getSessionImgVerifyCode(UserSession userSession);
}