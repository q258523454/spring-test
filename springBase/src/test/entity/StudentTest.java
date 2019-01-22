package entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class StudentTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring_config.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(JSONObject.toJSONString(student));
        System.out.println(student);
    }

}