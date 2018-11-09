package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.UserFastJsonSerializer;
import com.service.UserFastJsonSerializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController_FastJsonSerializer {
    @Autowired
    private UserFastJsonSerializerService userFastJsonSerializerService;

    @RequestMapping(value = "/UserController_FastJsonSerializer")
    public @ResponseBody
    String UserController_FastJsonSerializer() throws Exception {
        UserFastJsonSerializer user = userFastJsonSerializerService.selectByPrimaryKey(134);
        System.out.println(JSONObject.toJSONString(user));
        return "success";
    }
}