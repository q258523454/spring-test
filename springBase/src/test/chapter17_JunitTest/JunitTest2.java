package chapter17_JunitTest;

import chapter17_JunitTest.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class JunitTest2 {


    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.saveUser();
    }


}