package com.userLogin.entity;

public class UserRegister {
    // id
    private Integer id;

    // 姓名
    private String name;

    // 年龄
    private Integer age;

    // 电话号码
    private String telephone;

    // code
    private String code;

    // 
    private String username;

    // 
    private String password;

    // 返回数据辅助变量
    private String res;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}