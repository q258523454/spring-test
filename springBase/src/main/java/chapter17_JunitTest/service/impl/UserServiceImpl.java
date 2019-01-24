package chapter17_JunitTest.service.impl;

import chapter17_JunitTest.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-24
 */


@Service("userService")
@PropertySource("classpath:properties/user.properties")
public class UserServiceImpl implements UserService {

    @Value("${id}")
    private String id;

    @Value("${name}")
    private String name;


    public UserServiceImpl() {
    }


    public UserServiceImpl(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void saveUser() {
        System.out.println("用户编码：" + id + ";   用户名：" + name);
    }
}
