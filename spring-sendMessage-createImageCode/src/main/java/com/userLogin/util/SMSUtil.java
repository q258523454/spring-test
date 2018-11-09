package com.userLogin.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author zhang
 */
public class SMSUtil {
//    @Autowired
//    private SmsSender smsSender; // 不可以直接使用@Autowired，因为方法是static，方法中使用的对象也必须是static

    public static Map<String, String> sendSMS(String telephone, String body) throws Exception {
        SmsSender smsSender = SpringContextHolder.getBean("smsSender");
        JSONObject jo = JSONObject.parseObject(body);
        String content = String.format("%s为您的登录验证码，请于%s秒内填写。如非本人操作，请忽略本短信", jo.get("verifyCodeJson"), jo.get("validateTimeJson"));
        smsSender.sendSmsUtil(null, telephone, content);
        return null;
    }
}
