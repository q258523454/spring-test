package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-03-18
 */
@RestController
public class IndexController {

    @RequestMapping("/sessionTest")
    public void sessionTest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println(" ---------------------- Cookies1 BEGIN ----------------------");
        // 首次访问
        // 1.Request中Cookies为null, 所有是没有SESSION(即JSESSIONID)的, request.getCookies会创建cookies
        // 2.Request中Session是null, 直到使用request.getSession(因为它会创建session, 返回到客户端的时候才写入到cookies)
        for (Cookie cookie : request.getCookies()) {
            // 没有session
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
        System.out.println(" ---------------------- Cookies1 END ----------------------");

        // 下面这句将创建session
        System.out.println(request.getSession().getId());

        System.out.println(" ---------------------- Cookies2 BEGIN ----------------------");
        for (Cookie cookie : request.getCookies()) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
            if (cookie.getName().equals("JSESSIONID")) {
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
            }
        }
        System.out.println(" ---------------------- Cookies2 END ----------------------");
    }
}
