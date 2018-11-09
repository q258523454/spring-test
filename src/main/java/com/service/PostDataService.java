package com.service;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-04-28
 */

public interface PostDataService {
    void postJsonData(String URL, JSONObject jsonObject) throws IOException;

    StringBuffer postHttpJsonData(String URL, JSONObject jsonObject, JSONObject responseJsonMap, int... timeoutArrays) throws Exception;
}

