package chapter14_AOP.aop;

import chapter14_AOP.joincut.Animals;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class personAdviceTest {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring/spring-aop.xml");
        Animals personProxy = (Animals) factory.getBean("personFactory");
        personProxy.eat();
        personProxy.wc();
    }

}