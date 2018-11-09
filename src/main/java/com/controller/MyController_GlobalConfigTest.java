package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.AppWeChatUser;
import com.service.PostDataService;
import com.util.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController_GlobalConfigTest {
    @Autowired
    private GlobalConfig globalConfig;

    @RequestMapping(value = "/MyController_GlobalConfigTest", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String MyController_GlobalConfigTest(HttpServletRequest httpServletRequest) throws Exception {

        String str = JSONObject.toJSONString(globalConfig);
        return str;
    }

}