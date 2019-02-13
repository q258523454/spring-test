package controller;
// Created by ZhangJian on 18/3/2.


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    // 获取图片验证码测试
    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    @ResponseBody
    public String userUpdate(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("doing userUpdate");
        return "userUpdate";
    }

}
