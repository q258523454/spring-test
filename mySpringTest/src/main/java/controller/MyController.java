package controller;
// Created by ZhangJian on 18/3/2.


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.CheckCodeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {


    // 获取图片验证码测试
    @RequestMapping("/getCheckImageTest")
    @ResponseBody
    public void getCheckImageTest(HttpServletRequest request, HttpServletResponse response) {
        String imgCode = CheckCodeUtil.createImage(request, response);//生成图片验证码
        System.out.println(imgCode);

    }

}
