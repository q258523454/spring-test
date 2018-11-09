package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.service.PostDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    private PostDataService postDataService;

    // @ResponseBody : 注解之后不会再走试图处理器，而是直接将数据写入到输入流, 所以下面会返回 /WEB-INF/views/index.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        return "DaGong";
    }

    @RequestMapping(value = "/dagong", method = RequestMethod.GET)
    public String DaGong() throws Exception {
        return "DaGong";
    }

    @RequestMapping(value = "/print")
    public @ResponseBody
    String postData() throws Exception {

        return "success";
    }


    @RequestMapping(value = "/fastJsonParse", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String postFastJsonParse(HttpServletRequest httpServletRequest) throws Exception {
        httpServletRequest.setCharacterEncoding("UTF-8");               // 解决中文乱码问题
        String a = httpServletRequest.getParameter("a");
        String b = httpServletRequest.getParameter("b");
        BufferedReader bufferReader = httpServletRequest.getReader();   // 获取头部参数信息(post数据头部信息,用来读取post数据)
        StringBuffer buffer = new StringBuffer();
        String line = " ";
        while ((line = bufferReader.readLine()) != null) {
            buffer.append(line);
        }
        String results = buffer.toString();
        //System.out.println(postData);
        // 返回到post客户端(这里是本机服务器)的数据, 客户端用connection.getInputStream()获取
        return results;
    }


}