package chapter13_DI.beanfactory;

import chapter13_DI.entity.Teacher;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        // 1、声明注册bean
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("teacher");
        beanObj.setClassPath("chapter13_DI.entity.Teacher");

        // 设置 property
        Map<String, String> propertyMap = beanObj.getPropertyMap();
        propertyMap.put("teacherName", "AlanShelby");
        propertyMap.put("friendArray", "Mike,Tom,Alex");
        propertyMap.put("school", "牛津大学,哥伦比亚大学,美国斯坦福大学");
        List<BeanDefined> configuration = new ArrayList<>();
        configuration.add(beanObj);

        // 2、声明一个BeanFactory，类似于Spring中的ApplicationContext
        BeanFactory factory = new BeanFactory(configuration);

        // 3、开发人员向BeanFactory索要实例对象
        Teacher teacher = (Teacher) factory.getBean("teacher");
        System.out.println(JSONObject.toJSONString(teacher));
    }

}