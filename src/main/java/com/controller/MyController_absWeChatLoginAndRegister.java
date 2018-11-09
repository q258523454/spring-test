package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.AppWeChatUser;
import com.service.PostDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController_absWeChatLoginAndRegister {
    @Autowired
    private PostDataService postDataService;


    @RequestMapping(value = "/userLogin", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String userLogin(HttpServletRequest httpServletRequest) throws Exception {
        AppWeChatUser appWeChatUser = new AppWeChatUser();
        appWeChatUser.setOrganizationName("蚂蚁小程序机构");
        appWeChatUser.setContactName("张三");
        appWeChatUser.setContactEmail("zhangsan123@qq.com");
        appWeChatUser.setContactWechat("Wechat123");
        appWeChatUser.setReferee("李四");
        appWeChatUser.setContactPhone("13266846736");

        JSONObject postJsonObject = JSONObject.parseObject(JSONObject.toJSONString(appWeChatUser));
        JSONObject res = new JSONObject();

        String URL1 = "http://localhost:8081/appWeChat/userLogin";
        String URL2 = "https://ta.abscloud.com/appWeChat/userLogin";

        postDataService.postHttpJsonData(URL2, postJsonObject, res);

        return res.toJSONString();
    }

    @RequestMapping(value = "/isExistPhone", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String isExistPhone(HttpServletRequest httpServletRequest) throws Exception {

        String URL3 = "http://localhost:8080/appWeChat/isExistPhone";
        String URL4 = "https://ta.abscloud.com/appWeChat/isExistPhone";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("telephone", "13266841234");
        JSONObject res = new JSONObject();
        postDataService.postHttpJsonData(URL4, jsonObject, res);
        return res.toJSONString();
    }

}