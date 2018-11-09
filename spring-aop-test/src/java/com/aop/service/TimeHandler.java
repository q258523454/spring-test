package com.aop.service;

import org.springframework.stereotype.Service;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-03-28
 */

@Service
public class TimeHandler
{
    public void printTime()
    {
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
}
