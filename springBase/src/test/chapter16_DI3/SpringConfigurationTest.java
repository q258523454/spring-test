package chapter16_DI3;

import chapter16_DI3.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */
public class SpringConfigurationTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        System.out.println(JSONObject.toJSONString(userService));
    }

}