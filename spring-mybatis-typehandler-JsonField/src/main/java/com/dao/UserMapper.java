package com.dao;

import com.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUser();

    public int insertUser(User user);
}
