package chapter13_DI.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class TeacherTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-DI.xml");
        Teacher teacher = (Teacher) applicationContext.getBean("teacher");
        System.out.println(JSONObject.toJSONString(teacher));
    }
}