package com.entity;

import java.math.BigDecimal;

public class TsBorrowerInfo {
    //id
    private Integer id;

    //贷款合同编号
    private String deal_no;

    //借款人姓名
    private String borrower_name;

    //借款人类型
    private String borrower_type;

    //证件类型
    private String id_type;

    //证件号
    private String id_no;

    //借款人性别
    private String sex;

    //出生日期
    private String birthday;

    //年龄
    private String borrower_age;

    //婚姻状况
    private String marital_status;

    //职业
    private String industry;

    //年收入
    private BigDecimal year_income;

    //省份、直辖市
    private String province;

    //省份/直辖市对应编码
    private String province_code;

    //所在地区
    private String address;

    //收入债务比
    private BigDecimal debt_income_per;

    //借款人内部评级
    private String borrower_rating;

    //家庭状况
    private String family_status;

    //国籍
    private String nationality;

    //家庭住址
    private String family_address;

    //教育程度
    private String education_level;

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

    //标识字段：0:正常，1：无效
    private String is_valid;

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

    public String getDeal_no() {
        return deal_no;
    }

    public void setDeal_no(String deal_no) {
        this.deal_no = deal_no;
    }

    public String getBorrower_name() {
        return borrower_name;
    }

    public void setBorrower_name(String borrower_name) {
        this.borrower_name = borrower_name;
    }

    public String getBorrower_type() {
        return borrower_type;
    }

    public void setBorrower_type(String borrower_type) {
        this.borrower_type = borrower_type;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_no() {
        return id_no;
    }

    public void setId_no(String id_no) {
        this.id_no = id_no;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBorrower_age() {
        return borrower_age;
    }

    public void setBorrower_age(String borrower_age) {
        this.borrower_age = borrower_age;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public BigDecimal getYear_income() {
        return year_income;
    }

    public void setYear_income(BigDecimal year_income) {
        this.year_income = year_income;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getDebt_income_per() {
        return debt_income_per;
    }

    public void setDebt_income_per(BigDecimal debt_income_per) {
        this.debt_income_per = debt_income_per;
    }

    public String getBorrower_rating() {
        return borrower_rating;
    }

    public void setBorrower_rating(String borrower_rating) {
        this.borrower_rating = borrower_rating;
    }

    public String getFamily_status() {
        return family_status;
    }

    public void setFamily_status(String family_status) {
        this.family_status = family_status;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFamily_address() {
        return family_address;
    }

    public void setFamily_address(String family_address) {
        this.family_address = family_address;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
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

    public String getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(String is_valid) {
        this.is_valid = is_valid;
    }
}