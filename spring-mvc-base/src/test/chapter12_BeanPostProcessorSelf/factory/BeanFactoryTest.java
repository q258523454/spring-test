package chapter12_BeanPostProcessorSelf.factory;

import chapter11_factory.entity.BeanDefined;
import chapter12_BeanPostProcessor.service.BaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BeanFactoryTest {
    public static void main(String[] args) throws Exception {
        // 1、声明注册bean
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("baseServiceImpl");
        beanObj.setClassPath("chapter12_BeanPostProcessor.service.impl.BaseServiceImpl");

        // 获取工厂类
        BeanDefined beanObj1 = new BeanDefined();
        beanObj1.setClassPath("chapter12_BeanPostProcessorSelf.utils.MyGlobalPostProcessor");

        List<BeanDefined> configuration = new ArrayList<BeanDefined>();
        configuration.add(beanObj);
        configuration.add(beanObj1);

        // 2、声明一个BeanFactory，类似于Spring中的ApplicationContext
        BeanFactory factory = new BeanFactory(configuration);

        // 3、开发人员向BeanFactory索要实例对象
        BaseService baseService = (BaseService) factory.getBean("baseServiceImpl");
        System.out.println(baseService.eat());
        System.out.println(baseService.doSomething());
    }

}