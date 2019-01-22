package entity2;

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

    private Map<String, Object> mapScope;

    public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
    }

    public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
        this.beanDefinedList = beanDefinedList;
    }

    public BeanFactory(List<BeanDefined> beanDefinedList) throws Exception {
        this.beanDefinedList = beanDefinedList;
        mapScope = new HashMap<>();
        for (BeanDefined bean : beanDefinedList) {
            if (bean.getScope().equals("singleton")) {
                String classPath = bean.getClassPath();
                Class c = Class.forName(classPath);
                mapScope.put(bean.getBeanId(), c.newInstance());
            }
        }
    }


    public Object getBean(String beanId) throws Exception {
        Object instance;
        for (BeanDefined bean : beanDefinedList) {
            if (bean.getBeanId().equals(beanId)) {
                if (bean.getScope().equals("singleton")) {
                    return mapScope.get(bean.getBeanId());
                }
                String classPath = bean.getClassPath();
                Class c = Class.forName(classPath);
                instance = c.newInstance();
                return instance;
            }
        }
        return null;
    }
}
