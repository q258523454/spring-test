package chapter14_AOP.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-23
 */
public class BeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        System.out.println("洗手...");
    }
}
