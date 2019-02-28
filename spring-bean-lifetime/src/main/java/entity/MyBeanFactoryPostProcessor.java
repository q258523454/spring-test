package entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-13
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("【BeanFactoryPostProcessor】构造器");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // BeanFactoryPostProcessor这里赋值，在bean没有初始化之前?
        BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition("person");
        System.out.println(" Person Bean 配置实例化:name" + bd.getPropertyValues().get("name") + ",age=" + bd.getPropertyValues().get("age"));
        System.out.println("【BeanFactoryPostProcessor】{postProcessBeanFactory}:修改Person.age的值为:26");
        bd.getPropertyValues().addPropertyValue("age", "26");
    }
}
