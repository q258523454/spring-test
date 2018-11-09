package com.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController_SessionTest {

    @RequestMapping(value = "/MyController_SessionTest", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String MyController_SessionTest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(JSONObject.toJSONString(cookie));
        }
        System.out.println("------------------------------------------------------------");
//        Cookie newCookie = new Cookie("myTest", "ABCD");
//        newCookie.setMaxAge(5);
//        httpServletResponse.addCookie(newCookie);

        HttpSession httpSession = httpServletRequest.getSession();
        System.out.println(JSONObject.toJSONString(httpSession));
        httpSession.setAttribute("test", "abc");
        httpSession.setAttribute("zhang", "jian");

        System.out.println(JSONObject.toJSONString(httpSession));
        System.out.println(httpSession.getAttribute("test"));
        System.out.println(httpSession.getAttribute("zhang"));


        return "";
    }


}