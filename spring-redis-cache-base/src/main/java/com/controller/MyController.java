package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.UUID;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test")
    public @ResponseBody
    String test() throws Exception {
        return "success";
    }


    // application/json; charset=UTF-8 防止中文乱码
    // test URL: http://localhost:port/a?id=4
    @RequestMapping(value = "/selectByPrimaryKey", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String selectByPrimaryKey(HttpServletRequest httpServletRequest) throws Exception {
        Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
        if (null != id) {
            User user = userService.selectByPrimaryKey(id);
            return JSONObject.toJSONString(user);
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/insertSelective", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String insertSelective() throws Exception {
        User user = new User();
        user.setName("redis" + UUID.randomUUID().toString().substring(3, 8));
        user.setAge(100);
        userService.insertSelective(user);
        return "插入完成:" + JSONObject.toJSONString(user);
    }

    @RequestMapping(value = "/deleteByPrimaryKey", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String deleteByPrimaryKey(HttpServletRequest httpServletRequest) throws Exception {
        Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
        userService.deleteByPrimaryKey(id);
        return "删除了记录,id=" + id;
    }

}