package chapter16_DI3;

import chapter16_DI3.service.UserService;
import chapter16_DI3.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */

// @Configuration  相当于 spring 配置文件中的 beans 标签 <beans></beans>
@Configuration

// @ComponentScan 相当于 context:component-scan 标签
@ComponentScan(basePackages = "chapter16_DI3.service.impl")

// @Import 引入其他配置类，多用于分模块开发
@Import(SubSpringConfiguration.class)
public class SpringConfiguration {
    public SpringConfiguration() {
        System.out.println("SpringConfiguration 容器初始化···");
    }

    // Bean 注解（相当于配置文件中的 bean 标签），可以指定 beanId，使用 value 属性指定；如果不指定，默认的 beanId 就是当前被注解方法的方法名称
//    @Bean(value = "userServiceImpl")
//    public UserService userService() {
//        return new UserServiceImpl();
//    }

}
