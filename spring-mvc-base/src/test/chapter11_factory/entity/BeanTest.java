package chapter11_factory.entity;

import chapter10_bean.entity.Student;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BeanTest {

    public static void main(String[] args) throws Exception {
        // 1、声明注册bean
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("student");
        beanObj.setClassPath("chapter10_bean.entity.Student");
        beanObj.setScope("singleton");
//        beanObj.setScope("prototype");
        List<BeanDefined> beanList = new ArrayList<BeanDefined>();
        beanList.add(beanObj);

        // 2、声明一个BeanFactory，类似于Spring中的ApplicationContext
        BeanFactory factory = new BeanFactory(beanList);

        // 3、开发人员向BeanFactory索要实例对象
        Student student1 = (Student) factory.getBean("student");
        System.out.println(student1 + ":" + JSONObject.toJSONString(student1));

        Student student2 = (Student) factory.getBean("student");
        System.out.println(student2 + ":" + JSONObject.toJSONString(student2));

    }

}