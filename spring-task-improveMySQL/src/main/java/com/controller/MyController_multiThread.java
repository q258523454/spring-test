package com.controller;

import com.service.TransactionService;
import com.service.TsAssetInfoService;
import com.service.TsBorrowerInfoService;
import com.util.ProvinceCityConstUtil;
import com.util.RunnableTask;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController_multiThread {
    private Logger log = Logger.getLogger(MyController_multiThread.class);

    @Autowired
    private TsAssetInfoService tsAssetInfoService;
    @Autowired
    private TsBorrowerInfoService tsBorrowerInfoService;
    @Autowired
    private TransactionService transactionService;


    // http://localhost:18085/makeData?projectId=8888&treadNum=10&threadMakeDataLength=100
    @RequestMapping(value = "/makeData")
    public @ResponseBody
    String makeData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        int treadNum = Integer.parseInt(request.getParameter("treadNum"));
        int threadMakeDataLength = Integer.parseInt(request.getParameter("threadMakeDataLength"));

        final List<String> provinceList = new ArrayList<>();
        for (String province : ProvinceCityConstUtil.provinceCityMap.keySet()) {
            provinceList.add(province);
        }

        for (int i = 0; i < treadNum; i++) {
            int r = (int) (Math.random() * (((provinceList.size() - 1) - 0) + 1));
            String provinceName = provinceList.get(r);  // 随机获取一个省份名
            List<String> cityList = ProvinceCityConstUtil.provinceCityMap.get(provinceName);    // 获取省份下所有的城市
            if ((cityList.size() - 1) != 0) {
                r = 0 + (int) (Math.random() * (((cityList.size() - 1) - 0) + 1));
            } else {
                r = 0;
            }
            String cityName = cityList.get(r);          // 随机获取一个省份下的城市名
            new Thread(new RunnableTask(projectId, provinceName, cityName, transactionService, threadMakeDataLength), "线程" + i).start();
        }
        log.info("Main Finished.");
        return "Doing Insert Data, wait.";
    }


}