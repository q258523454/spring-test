package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {

    User selectByPrimaryKey(int id);

    User selectMaxKeyUser();
    // 注意1:
    // 下面的插入语句: parameterType="com.entity.User" useGeneratedKeys="true" keyProperty="user.id"
    // mapper接口返回值依然是成功插入的记录数，但不同的是主键值已经赋值到领域模型实体的id中了
    // 注意2:
    // @Param("user") 加与不加是有区别的, 加了在sql中就需要用user.property来取值
    // 不加,则直接使用bean中的属性,不用加前缀 user
    Integer insertUser(User user);

    Integer delUserById(int id);
}