package controller;

import com.alibaba.fastjson.JSONObject;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-13
 */
public class BeanLifeCycleTest {

    public static void main(String[] args) {
        System.out.println(" ------------------------ 开始初始化容器 ------------------------");
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring/spring-mvc.xml");
        System.out.println(" ------------------------ 容器初始化成功 ------------------------");
        //得到Preson，并使用
        Person person = factory.getBean("person", Person.class);
        System.out.println(JSONObject.toJSONString(person));

        System.out.println(" ------------------------ 现在开始关闭容器 ------------------------");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}