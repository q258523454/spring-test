package chapter18_AOP_JDK.proxy;

import chapter18_AOP_JDK.service.UserService;
import chapter18_AOP_JDK.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */
public class MyProxy implements InvocationHandler {

    private Object target = null;

    // 代理————被代理, 建立连接
    public Object bind(Object target) {
        this.target = target;
        // this指的就是MyProxy, 必须实现InvocationHandler.invoke()
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before log..." + method.getName());
        Object obj = method.invoke(target, args); // 调用被代理对象的实现
        System.out.println("after log..." + method.getName());

        return obj;
    }

    public static void main(String[] args) {
        MyProxy myProxy = new MyProxy();
        UserService proxy = (UserService) myProxy.bind(new UserServiceImpl());
        proxy.saveUser();
    }
}
