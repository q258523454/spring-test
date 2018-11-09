package com.userLogin.controller;
// Created by ZhangJian on 18/3/2.

import com.alibaba.fastjson.JSONObject;
import com.userLogin.entity.UserRegister;
import com.userLogin.entity.UserSession;
import com.userLogin.service.UserRegisterService;
import com.userLogin.service.UserSessionService;
import com.userLogin.util.CheckCodeUtil;
import com.userLogin.util.SMSUtil;
import com.userLogin.util.SendEmailUti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
public class MyController {

    @Autowired
    UserRegisterService userRegisterService;

    @Autowired
    UserSessionService userSessionService;

    @Autowired
    SendEmailUti sendEmail;

    @RequestMapping(value = "/test")
    public @ResponseBody
    String abc() throws Exception {
        UserRegister userRegister;
        List<UserRegister> userRegisterList = userRegisterService.findAllUsers();
        return "success";
    }

    @RequestMapping("testLogin.do")
    public String testLogin(String username, String password) {
        if ("admin".equals(username)) {
            System.out.println(username + " 登录成功");
            return "loginSuccess";//逻辑视图名    跳转页面默认为转发
        }
        return "loginError";
    }


    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public UserRegister login(UserRegister loginUser) {
        List<UserRegister> userRegisterLists = userRegisterService.findAllUsers();
        UserRegister userRegisterRes = new UserRegister();
        List<String> usernameList = userRegisterService.findAllUserName();
        if (usernameList.contains(loginUser.getUsername())) {
            int ind = usernameList.indexOf(loginUser.getUsername());
            String password = userRegisterLists.get(ind).getPassword();
            if (password.equals(loginUser.getPassword())) {
                userRegisterRes.setRes("success");
            } else {
                userRegisterRes.setRes("passwordError");
            }
        } else {
            userRegisterRes.setRes("用户不存在");
        }
        return userRegisterRes;
    }


    @RequestMapping(value = "/zhangjian", method = RequestMethod.POST)
    @ResponseBody
    public String test(HttpServletRequest request, HttpSession session, HttpServletResponse response, String telephone) {
        String str = telephone;
        return str;
    }


    @RequestMapping(value = "/checkUserNameUnique", method = RequestMethod.GET)
    @ResponseBody
    public UserRegister checkUserNameUnique(HttpServletRequest request, HttpSession session, HttpServletResponse response, String username) {
        UserRegister userRegisterRes = new UserRegister();
        if (null != userRegisterService.findUserName(username)) {
            userRegisterRes.setRes("isExist");
        } else {
            userRegisterRes.setRes("notExist");
        }
        return userRegisterRes;
    }

    // 获取图片验证码
    @RequestMapping("/getCheckImage")
    @ResponseBody
    public void getCheckImage(HttpServletRequest request, HttpServletResponse response) {
        //获取 sessionid
        Cookie[] cookies = request.getCookies();
        Cookie subCookie = null;
        String sessionid = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("C_USER")) {
                    subCookie = c;
                    sessionid = subCookie.getValue();
                    break;
                } else if (c.getName().equals("JSESSIONID")) {
                    subCookie = c;
                    sessionid = subCookie.getValue();
                    break;
                }
            }
        } else {
            // TODO
            // 如果没有Cookies呢?
        }
        String imgCode = CheckCodeUtil.createImage(request, response);//生成图片验证码
        UserSession userSession = new UserSession();
        userSession.setSessionId(sessionid);
        userSession.setSessionCode(imgCode);

        Integer res = userSessionService.findSessionIdService(userSession);
        if (res == null) {
            userSessionService.insertSessionService(userSession);
        } else {
            userSessionService.updateSessionService(userSession);
        }

    }


    // 获取 session id 的图形验证码, 并返回一致性
    @RequestMapping(value = "/getImageVerifyCode")
    @ResponseBody
    public UserRegister getImageVerifyCode(HttpServletRequest request, HttpSession session, HttpServletResponse response, UserSession userSession) {
        //获取 sessionid
        Cookie[] cookies = request.getCookies();
        Cookie subCookie = null;
        String sessionid = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("C_USER")) {
                    subCookie = c;
                    sessionid = subCookie.getValue();
                    break;
                } else if (c.getName().equals("JSESSIONID")) {
                    subCookie = c;
                    sessionid = subCookie.getValue();
                    break;
                }
            }
        } else {
            // TODO
            // 如果没有Cookies呢?
        }

        UserRegister userRegister = new UserRegister();
        userSession.setSessionId(sessionid); // 根据session id 查询生成的图形验证码
        String imgCode = userSessionService.getSessionImgVerifyCodeService(userSession);
        if (imgCode.equalsIgnoreCase(userSession.getSessionCode())) {
            userRegister.setRes("true");
        } else {
            userRegister.setRes("false");
        }

        return userRegister;
    }


    @RequestMapping(value = "/sendSMS", method = RequestMethod.POST)
    public @ResponseBody
    String sendSMS(HttpServletRequest request, HttpSession session, HttpServletResponse response, String telephone) {
        //获取 sessionid
        Cookie[] cookies = request.getCookies();
        String jsessionid = null;
        if (cookies != null) {
            for (Cookie c : cookies)
                if (c.getName().equals("C_USER")) {
                    jsessionid = c.getValue();
                    break;
                }
        }

        if (telephone.isEmpty() || null == telephone) {
            telephone = "13266846736";
        }

        // 生成短信验证码
        String code = "";
        Random random = new Random();  //创建随机数生成器
        for (int i = 0; i < 6; i++) {
            String strRand = String.valueOf(random.nextInt(10));
            code = code + strRand;
        }
        JSONObject object = new JSONObject();
        object.put("verifyCodeJson", code); // 验证码
        object.put("validateTimeJson", "120"); // 设置有效时间为120s
        String body = object.toString();
        try {
            SMSUtil.sendSMS(telephone, body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object.toString();
    }


    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public @ResponseBody
    String sendEmail(HttpServletRequest request, HttpSession session, HttpServletResponse response, String toEmail) {
        //获取 sessionid
        Cookie[] cookies = request.getCookies();
        String jsessionid = null;

        if (cookies != null) {
            for (Cookie c : cookies)
                if (c.getName().equals("C_USER")) {
                    jsessionid = c.getValue();
                    break;
                }
        }

        if (null == toEmail || toEmail.isEmpty()) {
            toEmail = "258523454@qq.com";
        }

        String content = "您好,这是一封测试邮件,如果非本人操作,请忽略.";
        String subject = "ZhJ 邮件测试";
        try {
            sendEmail.send(null, toEmail, content, subject, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject object = new JSONObject();
        object.put("res", "ok"); // 设置有效时间为120s
        return object.toString();
    }
}
