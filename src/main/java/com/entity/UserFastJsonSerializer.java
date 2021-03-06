package com.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.util.FastJsonSerializerUtil;

import java.util.Date;

// 注意这里一定要实现 Serializable, 否则无法序列化 User 类
public class UserFastJsonSerializer {

    private int id;

    @JSONField(serializeUsing = FastJsonSerializerUtil.TestZhang.class)
    private String name;

    private Integer age;

    private Date insertTime;

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}