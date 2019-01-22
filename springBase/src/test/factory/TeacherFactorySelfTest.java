package factory;

import com.alibaba.fastjson.JSONObject;
import entity.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class TeacherFactorySelfTest {

    public static void main(String[] args) throws Exception {

        // 自定义动态工厂
        // 1、声明注册bean
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("teacher");
        beanObj.setClassPath("entity.Teacher");
        beanObj.setScope("prototype");
        beanObj.setFactoryBean("factory");
        beanObj.setFactoryMethod("createTeacher");

        // 获取工厂类
        BeanDefined beanObj1 = new BeanDefined();
        beanObj1.setBeanId("factory");
        beanObj1.setClassPath("factory.TeacherFactory");

        List<BeanDefined> configuration = new ArrayList<BeanDefined>();
        configuration.add(beanObj);
        configuration.add(beanObj1);

        // 2、声明一个BeanFactory，类似于Spring中的ApplicationContext
        // 自定义工厂类以及需要被实例化的对象都添加到了 springIoc 集合中
        BeanFactory factory = new BeanFactory(configuration);


        // 3、开发人员向BeanFactory索要实例对象
        Teacher teacher3 = (Teacher) factory.getBean("teacher");
        System.out.println(teacher3 + ":" + JSONObject.toJSONString(teacher3));

    }

}