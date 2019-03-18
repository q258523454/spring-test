package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.MyUser;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @RequestMapping(value = "/selectAllUserOrg", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String selectAllUserOrg(HttpServletRequest request, HttpServletResponse response) {
        List<MyUser> myUserList = userService.selectAllUserOrg();
        return JSONObject.toJSONString(myUserList);
    }

    // application/json; charset=UTF-8 防止中文乱码
    @RequestMapping(value = "/selectAllUserPro", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String selectAllUserPro(HttpServletRequest request, HttpServletResponse response) {
        List<MyUser> myUserList = userService.selectAllUserPro();
        return JSONObject.toJSONString(myUserList);
    }
}