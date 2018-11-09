package com.entity;

public class AppWeChatUser {

    private String organizationName;    // 机构名称,所属公司 (*)
    private String contactEmail;        // 联系人邮箱 (*)
    private String contactPhone;        // 联系人手机号 (*)
    private String contactName;         // 联系人姓名 (*)

    private String contactWechat;       // 联系人微信号 (可选)
    private String referee;             // 推荐人 (可选)

    private String orgId;               // 随机生成的机构id （机构会员注册信息表使用）

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactWechat() {
        return contactWechat;
    }

    public void setContactWechat(String contactWechat) {
        this.contactWechat = contactWechat;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String checkNecessary() {
        if (null == this.getContactPhone() || this.getContactPhone().equals("")) {
            return "手机号不能为空";
        }
        if (null == this.getContactEmail() || this.getContactEmail().equals("")) {
            return "邮箱不能为空";
        }
        if (null == this.getContactName() || this.getContactName().equals("")) {
            return "联系人不能为空";
        }
        if (null == this.getOrganizationName() || this.getOrganizationName().equals("")) {
            return "公司名称不能为空";
        }
        return null;
    }

}
