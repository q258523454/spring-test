package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.PostDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController_PostData {
    @Autowired
    private PostDataService postDataService;

    @RequestMapping(value = "/MyController_PostData", produces = "application/json; charset=UTF-8")
    public @ResponseBody
    String MyController_PostData(HttpServletRequest httpServletRequest) throws Exception {

        JSONObject postJsonObject = new JSONObject();
        postJsonObject.put("apid", "685");

        JSONObject res = new JSONObject();
        String URL = "http://localhost:8080/writePreRatingResults";
        postDataService.postHttpJsonData(URL, postJsonObject, res);

        return res.toJSONString();

    }

}