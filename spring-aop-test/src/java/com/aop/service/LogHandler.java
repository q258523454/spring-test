package com.aop.service;

import org.springframework.stereotype.Service;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-29
 */

public class LogHandler {
    public void LogBefore() {
        System.out.println("Log before method");
    }

    public void LogAfter() {
        System.out.println("Log after method");
    }
}
