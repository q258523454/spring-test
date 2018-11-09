package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    // @ResponseBody : 注解之后不会再走试图处理器，而是直接将数据写入到输入流, 下面会返回 /WEB-INF/views/index.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        return "DaGong";
    }

    @RequestMapping(value = "/test")
    public @ResponseBody
    String test() throws Exception {
        return "success";
    }


    // application/json; charset=UTF-8 防止中文乱码
    // test URL: http://localhost:port/a?id=4
    @RequestMapping(value = "/a", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String a(HttpServletRequest httpServletRequest) throws Exception {
        Integer id = Integer.parseInt(httpServletRequest.getParameter("id"));
        if (null != id) {
            User user = userService.selectByPrimaryKey(id);
            return JSONObject.toJSONString(user);
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/b", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String b() throws Exception {
        User user = new User();
        user.setName("redist1");
        user.setAge(100);
        userService.insertSelective(user);
        return "插入完成:" + JSONObject.toJSONString(user);
    }

    @RequestMapping(value = "/del", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String del(HttpServletRequest httpServletRequest) throws Exception {
        Integer id;
        if (null == httpServletRequest.getParameter("id")) {
            id = null;
        }else {
            id = Integer.parseInt(httpServletRequest.getParameter("id"));
        }
        if (null == id) {
            User user = userService.selectMaxKeyUser();
            userService.deleteByPrimaryKey(user.getId());
            return "删除了最大记录,id=" + user.getId();
        } else {
            userService.deleteByPrimaryKey(id);
            return "删除了记录,id=" + id;
        }

    }

}