package entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-02-13
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("【BeanPostProcessor】实现类构造器！！");
        // TODO Auto-generated constructor stub
    }

    // 第一个参数都是要处理的Bean对象，第二个参数都是Bean的name
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("【BeanPostProcessor】接口方法{postProcessBeforeInitialization}对属性进行更改！");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("【BeanPostProcessor】接口方法{postProcessAfterInitialization}对属性进行更改！");
        return o;
    }
}