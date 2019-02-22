package com.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.util.FastJsonSerializerUtil;

import java.util.List;


public class Person {

    @JSONField(serializeUsing = FastJsonSerializerUtil.LongTest.class)
    private Long id;

    private List<String> interest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;

    }
}
