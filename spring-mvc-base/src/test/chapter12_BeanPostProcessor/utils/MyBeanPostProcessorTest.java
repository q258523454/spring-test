package chapter12_BeanPostProcessor.utils;

import chapter12_BeanPostProcessor.service.BaseService;
import chapter12_BeanPostProcessor.service.BaseService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */


public class MyBeanPostProcessorTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-beanPostProcessor.xml");
        BaseService baseService = (BaseService) applicationContext.getBean("baseServiceImpl");
        BaseService2 baseService2 = (BaseService2) applicationContext.getBean("baseServiceImpl2");
        System.out.println(baseService.doSomething());
        System.out.println(baseService2.doSomething());
    }
}