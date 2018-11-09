package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.entity.User2;
import com.service.PostDataService;
import com.service.User2Service;
import com.service.UserService;
import com.service.impl.TransactionTest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class userController_TestTransaction {

    Logger logger = Logger.getLogger(userController_TestTransaction.class);

    @Autowired
    private PostDataService postDataService;
    @Autowired
    private UserService userService;
    @Autowired
    private User2Service user2Service;

    @Autowired
    private TransactionTest transactionTestUtil;

    @RequestMapping(value = "/basicTest", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String basicTest() {
        try {

            String name = UUID.randomUUID().toString();
            String name2 = UUID.randomUUID().toString();
            User user = new User();
            user.setName(name);
            user.setAge(1);

            User2 user2 = new User2();
            user2.setName(name2);
            user2.setAge(2);

            insertTestHaveException(user, user2); // 测试:调用(类)内部方法是无法回滚的, 虽然内部方法有注解 @Transactional
            transactionTestUtil.insertTestHaveException(user, user2); // 可以回滚
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @RequestMapping(value = "/testTransactional", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String testTransactional() {
        try {
            String name = UUID.randomUUID().toString();
            String name2 = UUID.randomUUID().toString();
            User user = new User();
            user.setName(name);
            user.setAge(1);

            User2 user2 = new User2();
            user2.setName(name2);
            user2.setAge(2);


            // 不是事务, 内部方法
            insertTest2();// A.
            // 是事务,其他类方法
            transactionTestUtil.insertUser2(); // B.
            // 假如A, B 没有出现异常, C这里出现异常, 会自动回滚C事务, 但不会回滚A和B的操作
            transactionTestUtil.insertTestHaveException(user, user2); // C.

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("可以做一些事情");
        }
        return "ok";
    }


    @RequestMapping(value = "/testTransactional2", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody String testTransactional2() {
        String name = UUID.randomUUID().toString();
        String name2 = UUID.randomUUID().toString();
        User user = new User();
        user.setName(name);
        user.setAge(12);

        User2 user2 = new User2();
        user2.setName(name2);
        user2.setAge(22);

        try {
            insertTest1();// 不是事务, 是内部方法
            transactionTestUtil.insertUser2(); // 是事务,外部(类)方法
            String string = null;
            if (string.equals("")) {
                int i = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("捕获异常, catch插入数据.");
            // transactionTestUtil.insertTestNoException();
            try {
                // 出现异常, 发生回滚
                transactionTestUtil.insertTestHaveException(user, user2);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "ok";
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public String insertTestHaveException(User user, User2 user2) {
        List<User> userList = userService.selectAllUser();
        System.out.println(JSONObject.toJSONString(userList));
        List<User2> user2List = user2Service.selectAllUser();
        System.out.println(JSONObject.toJSONString(user2List));


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


    public String insertTest1() {
        String uuid2 = UUID.randomUUID().toString();
        User user1 = new User();
        user1.setName(uuid2);
        user1.setAge(10);
        System.out.println(JSONObject.toJSONString(user1));
        userService.insertUser(user1);
        System.out.println("finish insertTest1 user1");
        return "insertTest1 ok";
    }


    public String insertTest2() {
        String uuid2 = UUID.randomUUID().toString();
        User2 user2 = new User2();
        user2.setName(uuid2);
        user2.setAge(0);
        System.out.println(JSONObject.toJSONString(user2));
        user2Service.insertUser(user2);
        System.out.println("finish insertTest2 user2");
        return "insertTest ok";
    }

}