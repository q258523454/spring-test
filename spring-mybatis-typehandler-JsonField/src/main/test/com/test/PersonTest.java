package com.test;

import com.alibaba.fastjson.JSONObject;
import com.dao.PersonMapper;
import com.entity.Person;
import com.util.DBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-21
 */

public class PersonTest {
    @Test
    public void insertPersonStringList() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            for (int i = 0; i < 3; i++) {
                Person p = new Person();
                List<String> list = new ArrayList<String>();
                list.add("足球" + (int) (Math.random() * 10));
                list.add("排球" + (int) (Math.random() * 10));
                list.add("音乐" + (int) (Math.random() * 10));
                list.add("读书" + (int) (Math.random() * 10));
                p.setInterest(list);
                personMapper.insertPerson(p);
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
    public void selectPersonListTest() throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtils.openSqlSession();
            PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
            List<Person> people = personMapper.getPersonById_StringList(137);
            for (Person person : people) {
                System.out.println(JSONObject.toJSONString(people));
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