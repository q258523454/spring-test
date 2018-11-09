package com.aop.service.impl;

import com.aop.service.HelloWorld;
import org.springframework.stereotype.Service;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-28
 */

@Service
public class HelloWorldImpl1 implements HelloWorld {
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl1.printHelloWorld()");
    }

    public void doPrint() {
        System.out.println("Enter HelloWorldImpl1.doPrint()");
        return;
    }
}