package web;
// Created by ZhangJian on 18/2/26.


import zhang.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zhang.service.Test2;

@Controller
public class Zhang {
    @Autowired
    private Test test;

    @Autowired
    private Test2 test2;

    @RequestMapping(value="/test",produces = "application/json; charset=UTF-8")
    public @ResponseBody String test() throws Exception{
        return test.zhang("test1 dubbo");
    }

    @RequestMapping(value="/test2",produces = "application/json; charset=UTF-8")
    public @ResponseBody String test2() throws Exception{
        return test2.zhang("test2 dubbo");
    }
}
