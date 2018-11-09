package com.controller;

import com.alibaba.fastjson.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MyController_GlobalExceptionHandler {

    // 拦截器配置路径: java/com/util/GlobalExceptionHandler.java

    @RequestMapping(value = "/NullPointerException", method = RequestMethod.GET)
    public @ResponseBody
    String NullPointerException() throws Exception {
        throw new NullPointerException();
    }


    @RequestMapping(value = "/Exception", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    String Exception() throws Exception {
        throw new Exception();
    }

    @RequestMapping(value = "/JSONException", method = RequestMethod.GET)
    public @ResponseBody
    String JSONException() throws Exception {
        throw new JSONException();
    }

    // 如果注解 @ResponseStatus 放到方法上面了, 无论方法有无异常, 都会返回error信息, 方法无异常的话, 仍会继续执行
    @RequestMapping(value = "/ResponseStatus", method = RequestMethod.GET)
    @ResponseStatus(reason = "测试找不到页面", value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    String ResponseStatus() throws Exception {
        System.out.println("anc");
        return "abc";
    }


}