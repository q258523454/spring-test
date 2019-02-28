package entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-13
 */


// Bean自身的方法和Bean级生命周期接口方法
// 为了方便演示，它实现了BeanNameAware、BeanFactoryAware、InitializingBean和DiposableBean这4个接口
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private int age;
    private BeanFactory beanFactory;
    private String beanName;


    public Person() {
        System.out.println("【Bean】构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【Bean】注入属性 name");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("【Bean】注入属性 age");
        this.age = age;
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【Bean】{init-method】:调用<bean>的init-method属性指定的方法");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("【Bean】{BeanNameAware.setBeanName()}:设置Bean的ID为:" + s);
        this.beanName = s;
    }

    // 让Bean拥有访问Spring容器的能力,spring的api耦合在一起，这种方式不推荐
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【Bean】{BeanFactoryAware.setBeanFactory()}:让Bean拥有访问Spring容器的能力");
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【Bean】{InitializingBean.afterPropertiesSet}:配置读取之后的方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }


    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的方法");
    }


}
