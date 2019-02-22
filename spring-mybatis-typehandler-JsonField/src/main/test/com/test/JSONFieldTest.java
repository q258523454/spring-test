package com.test;

import com.alibaba.fastjson.JSONObject;
import com.entity.Person;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-22
 */
public class JSONFieldTest {

    @Test
    public void testJsonFiled() {
        Person person = new Person();
        person.setId(999L);
        String[] s = {"a", "b"};
        person.setInterest(Arrays.asList(s));
        System.out.println(JSONObject.toJSONString(person));
    }
}
