package chapter18_AOP_JDK.proxy;

import chapter18_AOP_JDK.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */
public class MyProxyUtil {
    public static UserService getProxyByJDK(UserService service) {
        UserService userService = (UserService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("记录日志-开始");
                        // 下面的代码是反射中 API 的用法
                        // 改行代码，实际调用的是目标对象的方法
                        Object obj = method.invoke(service, args);
                        System.out.println("记录日志-结束");
                        return obj;
                    }
                });
        return userService;
    }
}
