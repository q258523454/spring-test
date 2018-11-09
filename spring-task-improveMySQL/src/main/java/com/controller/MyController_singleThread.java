package com.controller;

import com.entity.TsAssetInfo;
import com.entity.TsBorrowerInfo;
import com.service.TransactionService;
import com.service.TsAssetInfoService;
import com.service.TsBorrowerInfoService;
import com.util.ProvinceCityConstUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.util.Time.randBetween;

@Controller
public class MyController_singleThread {
    private Logger log = Logger.getLogger(MyController_multiThread.class);

    @Autowired
    private TsAssetInfoService tsAssetInfoService;
    @Autowired
    private TsBorrowerInfoService tsBorrowerInfoService;
    @Autowired
    private TransactionService transactionService;


    // http://localhost:18085/makeData2?n=100&projectId=9999

    /**
     * 单独插入100条数据，单线程耗时
     10588 ms
     8975 ms
     9084 ms
     8879 ms
     8936 ms
     */
    @RequestMapping(value = "/makeData2")
    public @ResponseBody
    String makeData2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String num = request.getParameter("n");
        String sProjectId = request.getParameter("projectId");

        List<String> provinceList = new ArrayList<>();
        for (String province : ProvinceCityConstUtil.provinceCityMap.keySet()) {
            provinceList.add(province);
        }

        long i = Long.parseLong(num);
        int projectId = Integer.parseInt(sProjectId);


        long s = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {

            TsBorrowerInfo tsBorrowerInfo = new TsBorrowerInfo();

            String dealNo = "Test-" + UUID.randomUUID().toString();

            tsBorrowerInfo.setDeal_no(dealNo);
            String name = UUID.randomUUID().toString().replace("-", "");
            tsBorrowerInfo.setBorrower_name(name.substring(0, name.length() - 5));
            tsBorrowerInfo.setBorrower_type("0");

            // Min + (int)(Math.random() * ((Max - Min) + 1))
            int age = 18 + (int) (Math.random() * ((100 - 18) + 1));
            tsBorrowerInfo.setBorrower_age(Integer.toString(age));  // 随机年龄

            int r = (int) (Math.random() * (((provinceList.size() - 1) - 0) + 1));
            String provinceName = provinceList.get(r);  // 随机获取一个省份名
            List<String> cityList = ProvinceCityConstUtil.provinceCityMap.get(provinceName);    // 获取省份下所有的城市
            if ((cityList.size() - 1) != 0) {
                r = 0 + (int) (Math.random() * (((cityList.size() - 1) - 0) + 1));
            } else {
                r = 0;
            }
            String cityName = cityList.get(r);          // 随机获取一个省份下的城市名

            tsBorrowerInfo.setProvince(provinceName);
            tsBorrowerInfo.setAddress(cityName);
            tsBorrowerInfo.setBorrower_rating("test");  // 借款人内部评级
            tsBorrowerInfo.setNationality("中国");
            int education = 1 + (int) (Math.random() * ((10 - 1) + 1));
            tsBorrowerInfo.setEducation_level(Integer.toString(education));
            tsBorrowerInfo.setIs_valid("0");    // '标识字段：0:正常，1：无效'
            tsBorrowerInfo.setYear_income(new BigDecimal((int) (Math.random() * ((100000000 - 0) + 1))));   // 年收入
            tsBorrowerInfo.setIsDelete("0");

            TsAssetInfo tsAssetInfo = new TsAssetInfo();
            tsAssetInfo.setDeal_no(dealNo);
            tsAssetInfo.setTs_project_info_id(projectId);
            tsAssetInfo.setAsset_type("1");
            tsAssetInfo.setAsset_amount(new BigDecimal((int) (Math.random() * ((100000000 - 0) + 1))));
            tsAssetInfo.setPacked_balance(new BigDecimal((int) (Math.random() * ((1000000 - 0) + 1))));
            tsAssetInfo.setAsset_rate(new BigDecimal(Math.random()).setScale(8, BigDecimal.ROUND_HALF_UP)); // 利率
            tsAssetInfo.setReal_rate(new BigDecimal(Math.random()).setScale(8, BigDecimal.ROUND_HALF_UP)); // 利率
            tsAssetInfo.setAsset_repayment_type("1");
            tsAssetInfo.setRepayment_freq("1");
            tsAssetInfo.setPay_date("24");

            // 创建随机日期
            tsAssetInfo.setAsset_sdate(randBetween(2010, 2014));
            tsAssetInfo.setAsset_edate(randBetween(2016, 2018));
            tsAssetInfo.setPacked_date(randBetween(2014, 2016));
            tsAssetInfo.setInputuser("-1");
            tsAssetInfo.setAsset_status("0");
            tsAssetInfo.setIsDelete("0");

            transactionService.insertAssetAndBorrowerInfo(tsAssetInfo, tsBorrowerInfo);
        }
        long e = System.currentTimeMillis();
        System.out.println("" + (e - s));
        return "success";
    }


}