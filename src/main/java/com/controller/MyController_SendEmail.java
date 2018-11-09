package com.controller;

import com.util.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-09-26
 */

@Controller
public class MyController_SendEmail {
    @Autowired
    private EmailSender emailSender;

    @RequestMapping(value = "/sendEmailTest", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String sendEmailTest() {
        // zhangj@handeholding.com
        // zhangj@xfintech.com.cn
        // String[] to = {"258523454@qq.com", "zhangj@xfintech.com.cn"};
        String[] to = {"258523454@qq.com"};
//        emailSender.send(to, "test", "2A", false);
        emailSender.sendAsyn(to, "test", "2A", false);
        System.out.println("ok");
        return "ok";
    }
}
