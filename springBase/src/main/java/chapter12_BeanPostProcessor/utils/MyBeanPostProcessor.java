package chapter12_BeanPostProcessor.utils;

import chapter12_BeanPostProcessor.service.impl.BaseServiceImpl;
import chapter12_BeanPostProcessor.service.impl.BaseServiceImpl2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before Bean Init()...");
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        Class myClass = bean.getClass();
        if (myClass == BaseServiceImpl.class || myClass == BaseServiceImpl2.class) {
            Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {

                /***
                 * @param proxy 代理监控对象
                 * @param method doSome()方法
                 * @param args doSome()方法执行时接收的实参
                 * @throws Throwable
                 */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(method.getName() + "被拦截了..");
                    String result = (String) method.invoke(bean, args);
                    return result.toUpperCase();
                }
            });
            return proxy;
        }

        return bean;
    }
}
