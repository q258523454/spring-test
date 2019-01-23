package chapter13_DI.beanfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class BeanDefined {
    private String beanId; // bean的id

    private String classPath; // bean的文件路径

    private String scope = "singleton";

    private String factoryBean = null;

    private String factoryMethod = null;

    private Map<String, String> propertyMap = new HashMap<>(); // 存放属性的集合

    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, String> propertyMap) {
        this.propertyMap = propertyMap;
    }
}
