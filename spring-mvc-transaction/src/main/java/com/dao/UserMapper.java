package com.dao;

import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    public List<User> getUser();

    public int insertUser(User user);
}
