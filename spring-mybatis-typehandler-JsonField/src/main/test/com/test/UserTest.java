package com.test;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserMapper;
import com.entity.User;
import com.util.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-21
 */

public class UserTest {


    @Test
    // 插入user数据
    public void insertUser() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setPassword("123");
            user.setUsername("李四");
            for (int i = 0; i < 3; i++) {
                user.setRegTime(new Date());
                userMapper.insertUser(user);
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    // 查询user数据
    public void selectUserInfo() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> list = userMapper.getUser();
            for (User user : list) {
                System.out.println(JSONObject.toJSONString(user));
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}