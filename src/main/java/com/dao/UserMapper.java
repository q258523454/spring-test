package com.dao;

import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    User selectByPrimaryKey(int id);
    User selectByPrimaryKey2(int id);

    Integer insertUser(User user);

    List<User> selectAllUser();

}