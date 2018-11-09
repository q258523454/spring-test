package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.entity.User2;
import com.service.User2Service;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.UUID;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-14
 */

@Service
public class TransactionTest {

    @Autowired
    private User2Service user2Service;
    @Autowired
    private UserService userService;

    // PROPAGATION_REQUIRED -- 支持当前事务，如果当前没有事务，就新建一个事务
    // 事务作用于:pulic
    // 事务默认回滚异常: NullPoint(空指针) --- unchecked: 我们无法检测到的
    // 默认不会回滚异常: IOException(IO读写)、TimeoutException(网络) --- checked: 可以人为检测到的
    @Transactional(propagation = Propagation.REQUIRED)
    public String insertTestNoException() {
        List<User> userList = userService.selectAllUser();
        System.out.println(JSONObject.toJSONString(userList));
        List<User2> user2List = user2Service.selectAllUser();
        System.out.println(JSONObject.toJSONString(user2List));

        String uuid = UUID.randomUUID().toString();
        User user = new User();
        user.setName(uuid);
        user.setAge(0);

        System.out.println(JSONObject.toJSONString(user));
        userService.insertUser(user);
        System.out.println("finish insertTest user");


        String uuid2 = UUID.randomUUID().toString();
        User2 user2 = new User2();
        user2.setName(uuid2);
        user2.setAge(0);
        System.out.println(JSONObject.toJSONString(user2));
        user2Service.insertUser(user2);
        System.out.println("finish insertTest user2");

//        String string = null;
//        if (string.equals("")) {
//            int i = 0;
//        }
        return "insertTest ok";
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String insertTestHaveException(User user,User2 user2) {

        System.out.println(JSONObject.toJSONString(user));
        userService.insertUser(user);
        System.out.println("finish insertTestHaveException user");

        System.out.println(JSONObject.toJSONString(user2));
        user2Service.insertUser(user2);
        System.out.println("finish insertTestHaveException user2");

        String string = null;
        if (string.equals("")) {
            int i = 0;
        }
        return "insertTest ok";
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransactionalTrycatchRollBack() {
        // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        // 当try{出现异常-不管异常是哪个子方法,包含所有子方法的异常}, 回滚并捕获异常
        //     注意: 前提是try{}中有定义事务,即至少有1个方法是用 @Transactional
        // 只要try{}出现异常,上面的方法会回滚try中的所有对数据库的操作,包括没有被 @Transactional 注解的 insertTest2()
        try {
            String name = UUID.randomUUID().toString();
            String name2 = UUID.randomUUID().toString();
            User user = new User();
            user.setName(name);
            user.setAge(1);

            User2 user2 = new User2();
            user2.setName(name2);
            user2.setAge(2);

            insertUser2();
            insertTestHaveException(user,user2);
        } catch (Exception e) {
            e.printStackTrace();
            // 注解事务的方法, 捕获异常强制回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("可以做一些事情");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUser2() {
        String uuid2 = UUID.randomUUID().toString();
        User2 user2 = new User2();
        user2.setName(uuid2);
        user2.setAge(0);
        System.out.println(JSONObject.toJSONString(user2));
        user2Service.insertUser(user2);
        System.out.println("finish transactionTestUtil.insertTest2 user2");
    }
}
