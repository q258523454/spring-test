package chapter12_BeanPostProcessorSelf.factory;


import chapter11_factory.entity.BeanDefined;
import chapter12_BeanPostProcessorSelf.utils.GlobalPostProcessor;

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

    private Map<String, Object> springIoc; // 存放已经创建好的实例对象（用于单例模式）

    private GlobalPostProcessor globalPostProcessorObj; // 后置对象

    /**
     * 判断当前对象是一个 bean 对象还是一个后置处理对象（根据接口进行判断）
     *
     * @param instance 当前的实例对象
     * @param myClass  当前的实例对象关联的类
     */
    private void isProcessor(Object instance, Class myClass) {
        Class[] classList = myClass.getInterfaces();
        if (classList == null) {
            return;
        }

        for (Class cls : classList) {
            if (cls == GlobalPostProcessor.class) {
                // 证明当前的实例对象是后置处理器
                this.globalPostProcessorObj = (GlobalPostProcessor) instance;
            }
        }
    }

    public BeanFactory(List<BeanDefined> beanDefinedList) throws Exception {
        this.beanDefinedList = beanDefinedList;
        springIoc = new HashMap<String, Object>(); // 所有scope="singleton"采用单例模式管理bean对象
        for (BeanDefined bean : beanDefinedList) {
            if ("singleton".equals(bean.getScope())) {
                String classPath = bean.getClassPath();
                Class myClass = Class.forName(classPath);
                Object instance = myClass.newInstance();
                // 如果bean是一个后置处理对象(BeanPostProcessor), 更新this.processorObj
                isProcessor(instance, myClass);
                springIoc.put(bean.getBeanId(), instance);
            }
        }
    }

    public Object getBean(String beanId) throws Exception {
        Object instance = null;
        Object proxyObj = null; // 当前实例对象的代理监控对象
        for (BeanDefined bean : beanDefinedList) {
            if (bean.getBeanId().equals(beanId)) {
                String classPath = bean.getClassPath();
                String scope = bean.getScope();
                String factoryBean = bean.getFactoryBean();
                String factoryMethod = bean.getFactoryMethod();
                if ("prototype".equals(scope)) {
                    // 查看是否指定了工厂
                    if (factoryBean != null && factoryMethod != null) {
                        // factoryBean和factoryMethod都不为空,那么说明是[动态工厂]
                        // 获取工厂的实例
                        Object factoryInstance = springIoc.get(factoryBean);
                        Method method = factoryInstance.getClass().getDeclaredMethod(factoryMethod, null);
                        method.setAccessible(true);
                        // 通过工厂的实例,调用创建对象的方法, 创建对象实例
                        instance = method.invoke(factoryInstance, null);
                    } else {
                        Class c = Class.forName(classPath);
                        instance = c.newInstance();
                    }
                } else if ("singleton".equals(scope)) {
                    instance = springIoc.get(bean.getBeanId());
                }
            }
            if (this.globalPostProcessorObj != null) {
                // 返回代理对象
                proxyObj = this.globalPostProcessorObj.postProcessBeforeInitialization(instance, beanId);
                proxyObj = null;
                proxyObj = this.globalPostProcessorObj.postProcessAfterInitialization(instance, beanId);
                return proxyObj;
            }
        }
        return instance;
    }
}

