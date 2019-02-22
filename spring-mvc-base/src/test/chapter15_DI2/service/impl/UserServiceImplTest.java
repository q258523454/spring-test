package chapter15_DI2.service.impl;

import chapter15_DI2.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */
public class UserServiceImplTest {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-DI2.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        System.out.println(JSONObject.toJSONString(userService));
    }

}