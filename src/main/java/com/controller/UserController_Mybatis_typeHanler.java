package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class UserController_Mybatis_typeHanler {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/UserController_Mybatis_typeHanler")
    public @ResponseBody
    String UserController_Mybatis_typeHanler() throws Exception {
//        @ContextConfiguration({"classpath:spring/localZhang/spring-mvc.xml","classpath:spring/localZhang/spring-mybatis.xml"})
        User user = new User();
        user.setName("abc");
        user.setAge((int) (Math.random() * 100));
        user.setInsertTime(new Date());

        System.out.println(JSONObject.toJSONString(user));
        userService.insertUser(user);

        User user1 = userService.selectByPrimaryKey(134);
        System.out.println(user1);
        return "success";
    }
}