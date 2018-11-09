package com.aop.controller;

import com.aop.service.HelloWorld;
import com.aop.util.SpringContextHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-28
 */

@Controller
public class Test {

    // @ResponseBody : 注解之后不会再走试图处理器，而是直接将数据写入到输入流, 下面会返回 /WEB-INF/views/index.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        return "index";
    }

    // 方法一：直接Run执行, 测试
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/aop.xml");

        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImpl2");
        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();

        System.out.println();
        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
    }

    // 方法二：Web tomcat 运行测试
    @RequestMapping(value = "/test")
    public @ResponseBody
    String abc() throws Exception {
        HelloWorld hw1 = (HelloWorld) SpringContextHolder.getBean("helloWorldImpl1");
        HelloWorld hw2 = (HelloWorld) SpringContextHolder.getBean("helloWorldImpl2");
        hw1.printHelloWorld();
        System.out.println();
        hw1.doPrint();
        System.out.println();
        hw2.printHelloWorld();
        System.out.println();
        hw2.doPrint();
        return "success";
    }
}
