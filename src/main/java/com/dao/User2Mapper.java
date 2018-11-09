package com.dao;

import com.entity.User2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User2Mapper {

    User2 selectByPrimaryKey(int id);

    Integer insertUser(User2 user);

    List<User2> selectAllUser();

}