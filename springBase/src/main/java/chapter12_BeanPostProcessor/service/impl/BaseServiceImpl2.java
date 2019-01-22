package chapter12_BeanPostProcessor.service.impl;

import chapter12_BeanPostProcessor.service.BaseService2;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BaseServiceImpl2 implements BaseService2 {
    @Override
    public String doSomething() {
        return "Hello BaseService2"; // 增强效果：返回内容全部大写
    }

    @Override
    public String eat() {
        return "eat apple";
    }
}
