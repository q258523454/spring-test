package com.userLogin.dao;

import com.userLogin.entity.UserRegister;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRegisterMapper {
    List<UserRegister> selectAllUsers();

    List<String> selectAllUserName();

    Integer findUserName(@Param("username") String username);

}