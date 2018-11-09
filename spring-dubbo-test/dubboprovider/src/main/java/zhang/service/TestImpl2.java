package zhang.service;
// Created by ZhangJian on 18/2/26.

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service("testImpl2")
// 默认的注解bean名字就是 "testImpl"
public class TestImpl2 implements Test2 {

    private Logger logger = Logger.getLogger(TestImpl2.class);

    @Override
    public String zhang(String a) {
        logger.info("provider test2()");
        return a;
    }
}
