package chapter13_DI.beanfactory;

import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class BeanFactory {
    private List<BeanDefined> beanDefinedList; // 存放bean的集合

    private Map<String, Object> springIoc; // 存放已经创建好的实例对象（用于单例模式）

    private BeanPostProcessor processorObj; // 后置对象

    public BeanFactory(List<BeanDefined> beanDefinedList) throws Exception {
        this.beanDefinedList = beanDefinedList;
        springIoc = new HashMap<String, Object>(); // 所有scope="singleton"采用单例模式管理bean对象
        for (BeanDefined bean : beanDefinedList) {
            if ("singleton".equals(bean.getScope())) {
                String classPath = bean.getClassPath();
                Class classFile = Class.forName(classPath);
                Object instance = classFile.newInstance();
                setValue(instance, classFile, bean.getPropertyMap());
                springIoc.put(bean.getBeanId(), instance);
            }
        }
    }

    /**
     * 依赖注入的方法
     *
     * @param instance    当前的实例对象
     * @param classFile   当前实例对象所关联的类文件
     * @param propertyMap 属性
     */
    public void setValue(Object instance, Class classFile, Map<String, String> propertyMap) throws Exception {
        // 获取当前类文件中所有的方法
        Method[] methods = classFile.getDeclaredMethods();
        // 循环遍历 propertyMap
        Set<String> fieldNameSet = propertyMap.keySet();
        Iterator<String> fieldNameIterator = fieldNameSet.iterator();
        while (fieldNameIterator.hasNext()) {
            String fieldName = fieldNameIterator.next();
            String value = propertyMap.get(fieldName);
            Field field = classFile.getDeclaredField(fieldName); // 同名属性对象
            String methodName = "set" + fieldName;
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                // 忽略大小写比对方法名是否相同
                if (methodName.equalsIgnoreCase(method.getName())) {
                    // 属性所属类型：Integer,String,Double,Boolean,List此处只举个别类型进行演示
                    Class<?> fieldType = field.getType();
                    if (fieldType == String.class) {
                        method.invoke(instance, value);
                    } else if (fieldType == Integer.class) {
                        method.invoke(instance, Integer.valueOf(value));
                    } else if (fieldType == Boolean.class) {
                        method.invoke(instance, Boolean.valueOf(value));
                    } else if (fieldType == List.class) {
                        // 此处不在进行集合的类型判断，直接使用 String 类型的 ArrayList
                        List<String> tempList = new ArrayList<>();
                        String[] fieldItemArray = value.split(",");
                        for (int j = 0; j < fieldItemArray.length; j++) {
                            tempList.add(fieldItemArray[j]);
                        }
                        method.invoke(instance, tempList);
                    } else { // 默认为数组
                        String[] dataArray = value.split(",");
                        Object[] paramArray = new Object[1];
                        paramArray[0] = dataArray;
                        method.invoke(instance, paramArray);
                    }
                    break;
                }
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
                if ("prototype".equals(scope)) {
                    Class c = Class.forName(classPath);
                    instance = c.newInstance();
                } else if ("singleton".equals(scope)) {
                    instance = springIoc.get(bean.getBeanId());
                }
            }
        }
        return instance;
    }
}
