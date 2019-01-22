package chapter12_BeanPostProcessor.service.impl;

import chapter12_BeanPostProcessor.service.BaseService;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-22
 */
public class BaseServiceImpl implements BaseService {
    @Override
    public String doSomething() {
        return "Hello BaseService"; // 增强效果：返回内容全部大写
    }

    @Override
    public String eat() {
        return "eat apple";
    }
}
