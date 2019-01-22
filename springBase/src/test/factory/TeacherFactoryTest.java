package factory;

import com.alibaba.fastjson.JSONObject;
import entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class TeacherFactoryTest {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-factory.xml");

        // 动态工厂:高并发的情况下会占用较多的内存
        Teacher teacher1 = (Teacher) applicationContext.getBean("teacher1");
        System.out.println(teacher1 + ":" + JSONObject.toJSONString(teacher1));

        // 静态工厂
        Teacher teacher2 = (Teacher) applicationContext.getBean("teacher2");
        System.out.println(teacher2 + ":" + JSONObject.toJSONString(teacher2));

    }

}