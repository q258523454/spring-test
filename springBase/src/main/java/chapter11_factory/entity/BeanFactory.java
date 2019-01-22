package chapter11_factory.entity;


import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BeanFactory {

    private List<BeanDefined> beanDefinedList; // 存放bean的集合

    private Map<String, Object> springIoc;

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }

    public BeanFactory(List<BeanDefined> beanDefinedList) throws Exception {
        this.beanDefinedList = beanDefinedList;
        springIoc = new HashMap<>();
        for (BeanDefined bean : beanDefinedList) {
            // 所有scope="singleton"采用单例模式管理bean对象, 或者是工厂对象
            if ("singleton".equals(bean.getScope())) {
                String classPath = bean.getClassPath(); // bean限定路径
                Class c = Class.forName(classPath);
                springIoc.put(bean.getBeanId(), c.newInstance());
            }
        }
    }


    public Object getBean(String beanId) throws Exception {
        Object instance = null;
        // beanDefinedList 相当于spring bean的容器, 没有添加到该容器, 说明该bean没有在spring初始化的时候装载
        for (BeanDefined bean : beanDefinedList) {
            if (bean.getBeanId().equals(beanId)) {
                String classPath = bean.getClassPath();
                String scope = bean.getScope();
                String factoryBean = bean.getFactoryBean();
                String factoryMethod = bean.getFactoryMethod();
                if ("prototype".equals(scope)) {
                    // 原型模式
                    if (factoryBean != null && factoryMethod != null) {
                        // factoryBean和factoryMethod都不为空,那么说明是[动态工厂]
                        // 获取工厂的实例
                        Object factoryInstance = springIoc.get(bean.getFactoryBean());
                        Method method = factoryInstance.getClass().getDeclaredMethod(factoryMethod, null);
                        method.setAccessible(true);
                        // 通过工厂的实例,调用创建对象的方法, 创建对象实例
                        instance = method.invoke(factoryInstance, null);
                    } else {
                        Class c = Class.forName(classPath);
                        instance = c.newInstance();
                    }
                } else {
                    // 单例模式
                    if ("singleton".equals(scope)) {
                        // 如果spring-.xml没有配置,则返回为空
                        instance = springIoc.get(bean.getBeanId());
                    }
                }
            }
        }
        return instance;
    }
}
