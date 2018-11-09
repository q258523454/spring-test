package com.userLogin.service;
// Created by ZhangJian on 18/3/2.

import com.userLogin.entity.UserRegister;

import java.util.List;

public interface UserRegisterService {
    List<UserRegister> findAllUsers();

    List<String> findAllUserName();

    Integer findUserName(String username);
}
