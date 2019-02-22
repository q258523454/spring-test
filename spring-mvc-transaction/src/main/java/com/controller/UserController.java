package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public String insertUser() {
        User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        user.setRegTime(new Date());
        return "" + userService.insertUser(user);
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser() {
        return JSONObject.toJSONString(userService.getUser());
    }

}