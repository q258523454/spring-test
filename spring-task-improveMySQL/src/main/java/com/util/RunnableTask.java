package com.util;

import com.entity.TsAssetInfo;
import com.entity.TsBorrowerInfo;
import com.service.TransactionService;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.UUID;

import static com.util.Time.randBetween;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-08-23
 */

public class RunnableTask implements Runnable {
    private Logger log = Logger.getLogger(RunnableTask.class);

    private int projectId;

    private String provinceName;

    private String cityName;

    private TransactionService transactionService;

    private int makeDataLength;


    RunnableTask() {
    }

    public RunnableTask(int projectId, String provinceName, String cityName, TransactionService transactionService, int makeDataLength) {
        this.projectId = projectId;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.transactionService = transactionService;
        this.makeDataLength = makeDataLength;
    }

    @Override
    public void run() {
        // 一个线程插入100条数据
        Long start = System.currentTimeMillis();
        for (int i = 0; i < this.makeDataLength; i++) {
            makeData(projectId, provinceName, cityName, transactionService);
        }
        Long end = System.currentTimeMillis();
        log.info(Thread.currentThread().getName() + "插入" + this.makeDataLength + "条数据完成,耗时:" + (end - start) + "ms");
    }


    public void makeData(int projectId, String provinceName, String cityName, TransactionService transactionService) {
        TsBorrowerInfo tsBorrowerInfo = new TsBorrowerInfo();

        String dealNo = "Test-" + UUID.randomUUID().toString();

        tsBorrowerInfo.setDeal_no(dealNo);
        String name = UUID.randomUUID().toString().replace("-", "");
        tsBorrowerInfo.setBorrower_name(name.substring(0, name.length() - 5));
        tsBorrowerInfo.setBorrower_type("0");

        // Min + (int)(Math.random() * ((Max - Min) + 1))
        int age = 18 + (int) (Math.random() * ((100 - 18) + 1));
        tsBorrowerInfo.setBorrower_age(Integer.toString(age));  // 随机年龄


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
        tsAssetInfo.setAsset_amount(new BigDecimal((int) (Math.random() * ((100000000 - 0) + 1)))); // 贷款合同金额/贷款初始金额（元）
        tsAssetInfo.setPacked_balance(new BigDecimal((int) (Math.random() * ((1000000 - 0) + 1)))); // 提取日本金余额
        tsAssetInfo.setAsset_rate(new BigDecimal(Math.random()).setScale(8, BigDecimal.ROUND_HALF_UP)); // 贷款发放时利率/合同利率
        tsAssetInfo.setReal_rate(new BigDecimal(Math.random()).setScale(8, BigDecimal.ROUND_HALF_UP));  // 贷款现行利率/入池/封包利率
        tsAssetInfo.setAsset_repayment_type("1");
        tsAssetInfo.setRepayment_freq("1");
        tsAssetInfo.setPay_date("24");

        // 创建随机日期
        tsAssetInfo.setAsset_sdate(randBetween(2010, 2014));    // 贷款发放日
        tsAssetInfo.setAsset_edate(randBetween(2016, 2018));    // 贷款到期日
        tsAssetInfo.setPacked_date(randBetween(2014, 2016));    // 提取日期
        tsAssetInfo.setInputuser("-1");
        tsAssetInfo.setAsset_status("0");
        tsAssetInfo.setIsDelete("0");

        transactionService.insertAssetAndBorrowerInfo(tsAssetInfo, tsBorrowerInfo);
    }


}
