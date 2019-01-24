package chapter17_JunitTest;

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
@ComponentScan(basePackages = "chapter17_JunitTest.service.impl")

// @Import 引入其他配置类，多用于分模块开发
@Import(SubSpringConfiguration.class)
public class SpringConfiguration {
    public SpringConfiguration() {
        System.out.println("SpringConfiguration 容器初始化···");
    }
}
