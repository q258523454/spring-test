package entity;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {

        // 1、声明注册bean
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("student");
        beanObj.setClassPath("entity.Student");
        List<BeanDefined> beanList = new ArrayList<BeanDefined>();
        beanList.add(beanObj);

        // 2、声明一个BeanFactory，类似于Spring中的ApplicationContext
        BeanFactory factory = new BeanFactory();
        factory.setBeanDefinedList(beanList);

        // 3、开发人员向BeanFactory索要实例对象
        Student student = (Student) factory.getBean("student");
        System.out.println(JSONObject.toJSONString(student));

    }

}