package entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-13
 */

// 本质是BeanPostProcessor的子接口
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("【InstantiationAwareBeanPostProcessorAdapter】实现类构造器！！");
    }

    // 接口方法、实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor】实例化Bean之前调用 {postProcessBeforeInstantiation} 方法");
        return null;
    }

    // 接口方法、实例化Bean之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor】实例化Bean之后调用{postProcessAfterInitialization}方法");
        return bean;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("【InstantiationAwareBeanPostProcessor】设置某个属性时调用{postProcessPropertyValues}方法");
        return pvs;
    }
}
