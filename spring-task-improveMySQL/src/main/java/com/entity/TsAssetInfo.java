package com.entity;

import java.math.BigDecimal;

public class TsAssetInfo {
    //id
    private Integer id;

    //借款人id
    private Integer ts_borrower_info_id;

    //担保方id
    private Integer ts_guarantee_info_id;

    //项目id
    private Integer ts_project_info_id;

    //合同id
    private Integer ts_contract_info_id;

    //资产编号
    private String asset_code;

    //资产名称
    private String asset_name;

    //资产类型
    private String asset_type;

    //贷款合同编号
    private String deal_no;

    //借据编号
    private String duebill_no;

    //借据状态
    private String duebill_status;

    //贷款合同金额/贷款初始金额（元）
    private BigDecimal asset_amount;

    //利率类型
    private String rate_type;

    //贷款发放时利率/合同利率
    private BigDecimal asset_rate;

    //基准利率: 130-一年存款，220-六个月至一年（含1年）贷款，230-一至三年（含3年）贷款，240-三至五年（含5年贷款），250-五年以上贷款
    private String benchmark_rate;

    //利差
    private BigDecimal spread_rate;

    //利率浮动方式
    private String rate_float_type;

    //利率调整方式
    private String rate_change_type;

    //资产状态
    private String asset_status;

    //贷款发放日
    private String asset_sdate;

    //贷款到期日
    private String asset_edate;

    //总还款期数
    private String asset_term;

    //本金利息支付方式/还款方式
    private String asset_repayment_type;

    //还款频率
    private String repayment_freq;

    //贷款还款日
    private String pay_date;

    //尾款金额（元）
    private BigDecimal asset_balance;

    //尾款金额占比
    private BigDecimal asset_balance_per;

    //消费用途
    private String asset_purpose;

    //担保方式
    private String asset_guarantee;

    //贷款第三方担保
    private String third_guarantee;

    //贷款抵押
    private String mortgage;

    //贷款抵押率
    private BigDecimal mortgage_rate;

    //提取日期
    private String packed_date;

    //提取日本金余额
    private BigDecimal packed_balance;

    //贷款现行利率/入池/封包利率
    private BigDecimal real_rate;

    //提取日剩余期限
    private BigDecimal remain_term;

    //贷款质量:1-正常，2-关注，3-次级，4-可疑，5-损失
    private String loan_way;

    //首次还本日期
    private String first_paydate;

    //还款计划
    private String repayment_plan;

    //所属分行
    private String branch_bank;

    //所属支行
    private String sub_branch_bank;

    //是否为银团类贷款
    private String is_syndicated_loan;

    //借款人信息与合同是否一致:0-否，1-是
    private String same_borrower;

    //保证人名称
    private String surety_name;

    //保证人担保金额
    private BigDecimal surety_money;

    //保证类型
    private String surety_type;

    //保证人二级行业
    private String surety_trade;

    //保证人评级
    private String credit_level;

    //抵质押物名称
    private String pawn_name;

    //抵质押物担保金额
    private BigDecimal pawn_money;

    //抵质押品估值
    private BigDecimal collateral_value;

    //资产序列号
    private Integer orderid;

    //操作人
    private String inputuser;

    //创建日期
    private String crt_date;

    //创建时间
    private String crt_time;

    //更新日期
    private String upd_date;

    //创建时间
    private String upd_time;

    //债权评级
    private String bond_rating;

    private String isDelete;

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTs_borrower_info_id() {
        return ts_borrower_info_id;
    }

    public void setTs_borrower_info_id(Integer ts_borrower_info_id) {
        this.ts_borrower_info_id = ts_borrower_info_id;
    }

    public Integer getTs_guarantee_info_id() {
        return ts_guarantee_info_id;
    }

    public void setTs_guarantee_info_id(Integer ts_guarantee_info_id) {
        this.ts_guarantee_info_id = ts_guarantee_info_id;
    }

    public Integer getTs_project_info_id() {
        return ts_project_info_id;
    }

    public void setTs_project_info_id(Integer ts_project_info_id) {
        this.ts_project_info_id = ts_project_info_id;
    }

    public Integer getTs_contract_info_id() {
        return ts_contract_info_id;
    }

    public void setTs_contract_info_id(Integer ts_contract_info_id) {
        this.ts_contract_info_id = ts_contract_info_id;
    }

    public String getAsset_code() {
        return asset_code;
    }

    public void setAsset_code(String asset_code) {
        this.asset_code = asset_code;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getAsset_type() {
        return asset_type;
    }

    public void setAsset_type(String asset_type) {
        this.asset_type = asset_type;
    }

    public String getDeal_no() {
        return deal_no;
    }

    public void setDeal_no(String deal_no) {
        this.deal_no = deal_no;
    }

    public String getDuebill_no() {
        return duebill_no;
    }

    public void setDuebill_no(String duebill_no) {
        this.duebill_no = duebill_no;
    }

    public String getDuebill_status() {
        return duebill_status;
    }

    public void setDuebill_status(String duebill_status) {
        this.duebill_status = duebill_status;
    }

    public BigDecimal getAsset_amount() {
        return asset_amount;
    }

    public void setAsset_amount(BigDecimal asset_amount) {
        this.asset_amount = asset_amount;
    }

    public String getRate_type() {
        return rate_type;
    }

    public void setRate_type(String rate_type) {
        this.rate_type = rate_type;
    }

    public BigDecimal getAsset_rate() {
        return asset_rate;
    }

    public void setAsset_rate(BigDecimal asset_rate) {
        this.asset_rate = asset_rate;
    }

    public String getBenchmark_rate() {
        return benchmark_rate;
    }

    public void setBenchmark_rate(String benchmark_rate) {
        this.benchmark_rate = benchmark_rate;
    }

    public BigDecimal getSpread_rate() {
        return spread_rate;
    }

    public void setSpread_rate(BigDecimal spread_rate) {
        this.spread_rate = spread_rate;
    }

    public String getRate_float_type() {
        return rate_float_type;
    }

    public void setRate_float_type(String rate_float_type) {
        this.rate_float_type = rate_float_type;
    }

    public String getRate_change_type() {
        return rate_change_type;
    }

    public void setRate_change_type(String rate_change_type) {
        this.rate_change_type = rate_change_type;
    }

    public String getAsset_status() {
        return asset_status;
    }

    public void setAsset_status(String asset_status) {
        this.asset_status = asset_status;
    }

    public String getAsset_sdate() {
        return asset_sdate;
    }

    public void setAsset_sdate(String asset_sdate) {
        this.asset_sdate = asset_sdate;
    }

    public String getAsset_edate() {
        return asset_edate;
    }

    public void setAsset_edate(String asset_edate) {
        this.asset_edate = asset_edate;
    }

    public String getAsset_term() {
        return asset_term;
    }

    public void setAsset_term(String asset_term) {
        this.asset_term = asset_term;
    }

    public String getAsset_repayment_type() {
        return asset_repayment_type;
    }

    public void setAsset_repayment_type(String asset_repayment_type) {
        this.asset_repayment_type = asset_repayment_type;
    }

    public String getRepayment_freq() {
        return repayment_freq;
    }

    public void setRepayment_freq(String repayment_freq) {
        this.repayment_freq = repayment_freq;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public BigDecimal getAsset_balance() {
        return asset_balance;
    }

    public void setAsset_balance(BigDecimal asset_balance) {
        this.asset_balance = asset_balance;
    }

    public BigDecimal getAsset_balance_per() {
        return asset_balance_per;
    }

    public void setAsset_balance_per(BigDecimal asset_balance_per) {
        this.asset_balance_per = asset_balance_per;
    }

    public String getAsset_purpose() {
        return asset_purpose;
    }

    public void setAsset_purpose(String asset_purpose) {
        this.asset_purpose = asset_purpose;
    }

    public String getAsset_guarantee() {
        return asset_guarantee;
    }

    public void setAsset_guarantee(String asset_guarantee) {
        this.asset_guarantee = asset_guarantee;
    }

    public String getThird_guarantee() {
        return third_guarantee;
    }

    public void setThird_guarantee(String third_guarantee) {
        this.third_guarantee = third_guarantee;
    }

    public String getMortgage() {
        return mortgage;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }

    public BigDecimal getMortgage_rate() {
        return mortgage_rate;
    }

    public void setMortgage_rate(BigDecimal mortgage_rate) {
        this.mortgage_rate = mortgage_rate;
    }

    public String getPacked_date() {
        return packed_date;
    }

    public void setPacked_date(String packed_date) {
        this.packed_date = packed_date;
    }

    public BigDecimal getPacked_balance() {
        return packed_balance;
    }

    public void setPacked_balance(BigDecimal packed_balance) {
        this.packed_balance = packed_balance;
    }

    public BigDecimal getReal_rate() {
        return real_rate;
    }

    public void setReal_rate(BigDecimal real_rate) {
        this.real_rate = real_rate;
    }

    public BigDecimal getRemain_term() {
        return remain_term;
    }

    public void setRemain_term(BigDecimal remain_term) {
        this.remain_term = remain_term;
    }

    public String getLoan_way() {
        return loan_way;
    }

    public void setLoan_way(String loan_way) {
        this.loan_way = loan_way;
    }

    public String getFirst_paydate() {
        return first_paydate;
    }

    public void setFirst_paydate(String first_paydate) {
        this.first_paydate = first_paydate;
    }

    public String getRepayment_plan() {
        return repayment_plan;
    }

    public void setRepayment_plan(String repayment_plan) {
        this.repayment_plan = repayment_plan;
    }

    public String getBranch_bank() {
        return branch_bank;
    }

    public void setBranch_bank(String branch_bank) {
        this.branch_bank = branch_bank;
    }

    public String getSub_branch_bank() {
        return sub_branch_bank;
    }

    public void setSub_branch_bank(String sub_branch_bank) {
        this.sub_branch_bank = sub_branch_bank;
    }

    public String getIs_syndicated_loan() {
        return is_syndicated_loan;
    }

    public void setIs_syndicated_loan(String is_syndicated_loan) {
        this.is_syndicated_loan = is_syndicated_loan;
    }

    public String getSame_borrower() {
        return same_borrower;
    }

    public void setSame_borrower(String same_borrower) {
        this.same_borrower = same_borrower;
    }

    public String getSurety_name() {
        return surety_name;
    }

    public void setSurety_name(String surety_name) {
        this.surety_name = surety_name;
    }

    public BigDecimal getSurety_money() {
        return surety_money;
    }

    public void setSurety_money(BigDecimal surety_money) {
        this.surety_money = surety_money;
    }

    public String getSurety_type() {
        return surety_type;
    }

    public void setSurety_type(String surety_type) {
        this.surety_type = surety_type;
    }

    public String getSurety_trade() {
        return surety_trade;
    }

    public void setSurety_trade(String surety_trade) {
        this.surety_trade = surety_trade;
    }

    public String getCredit_level() {
        return credit_level;
    }

    public void setCredit_level(String credit_level) {
        this.credit_level = credit_level;
    }

    public String getPawn_name() {
        return pawn_name;
    }

    public void setPawn_name(String pawn_name) {
        this.pawn_name = pawn_name;
    }

    public BigDecimal getPawn_money() {
        return pawn_money;
    }

    public void setPawn_money(BigDecimal pawn_money) {
        this.pawn_money = pawn_money;
    }

    public BigDecimal getCollateral_value() {
        return collateral_value;
    }

    public void setCollateral_value(BigDecimal collateral_value) {
        this.collateral_value = collateral_value;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getInputuser() {
        return inputuser;
    }

    public void setInputuser(String inputuser) {
        this.inputuser = inputuser;
    }

    public String getCrt_date() {
        return crt_date;
    }

    public void setCrt_date(String crt_date) {
        this.crt_date = crt_date;
    }

    public String getCrt_time() {
        return crt_time;
    }

    public void setCrt_time(String crt_time) {
        this.crt_time = crt_time;
    }

    public String getUpd_date() {
        return upd_date;
    }

    public void setUpd_date(String upd_date) {
        this.upd_date = upd_date;
    }

    public String getUpd_time() {
        return upd_time;
    }

    public void setUpd_time(String upd_time) {
        this.upd_time = upd_time;
    }

    public String getBond_rating() {
        return bond_rating;
    }

    public void setBond_rating(String bond_rating) {
        this.bond_rating = bond_rating;
    }
}