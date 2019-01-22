package entity2;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BeanDefined {
    private String beanId; // bean的id

    private String classPath; // bean的文件路径

    private String scope = "singleton"; // scope模式, 默认为单例

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
}
