package com.dao;

import com.entity.User;
import com.entity.UserFastJsonSerializer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFastJsonSerializerMapper {

    UserFastJsonSerializer selectByPrimaryKey(int id);
    UserFastJsonSerializer selectByPrimaryKey2(int id);

    Integer insertUser(UserFastJsonSerializer user);

    List<UserFastJsonSerializer> selectAllUser();

}