package chapter12_BeanPostProcessorSelf.utils;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;


/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */

// 仿写源码接口: BeanPostProcessor
public interface GlobalPostProcessor {

    @Nullable
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Nullable
    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
