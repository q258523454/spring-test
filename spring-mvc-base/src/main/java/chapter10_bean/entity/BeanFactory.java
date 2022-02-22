package chapter10_bean.entity;

import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BeanFactory {
    private List<BeanDefined> beanDefinedList; // 存放bean的集合

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }

    // 利用反射机制、工厂模式得到bean实例
    public Object getBean(String beadId) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Object instance;
        for (BeanDefined bean : beanDefinedList) {
            if (bean.getBeanId().equals(beadId)) {
                String classPath = bean.getClassPath();
                Class c = Class.forName(classPath);
                instance = c.newInstance();
                return instance;
            }
        }
        return null;
    }
}
