package chapter17_JunitTest;

import chapter17_JunitTest.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */

public class JunitTest1 {


    private UserService userService;

    @Before
    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        userService = (UserService) context.getBean("userService");
    }

    @Test
    public void test() {
        userService.saveUser();
    }


}