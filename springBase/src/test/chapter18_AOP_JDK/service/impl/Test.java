package chapter18_AOP_JDK.service.impl;

import chapter18_AOP_JDK.SpringConfiguration;
import chapter18_AOP_JDK.proxy.MyProxyUtil;
import chapter18_AOP_JDK.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test {
    @org.junit.Test
    public void test() {
        UserService userService = new UserServiceImpl();
        UserService proxy = MyProxyUtil.getProxyByJDK(userService);
        proxy.saveUser();
    }

}