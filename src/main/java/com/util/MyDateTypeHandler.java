package com.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-21
 */

/*
    1.@MappedJdbcTypes定义的是JdbcType类型，这里的类型不可自己随意定义，必须要是枚举类org.apache.ibatis.type.JdbcType所枚举的数据类型。
    2.@MappedTypes定义的是JavaType的数据类型，描述了哪些Java类型可被拦截。
    3.在我们启用了我们自定义的这个TypeHandler之后，数据的读写都会被这个类所过滤
    4.在setNonNullParameter方法中，我们重新定义要写往数据库的数据。
    5.在另外三个方法中我们将从数据库读出的数据类型进行转换。

    一旦配置:
    <typeHandlers>
        <typeHandler handler="com.util.MyDateTypeHandler"/>
    </typeHandlers>
    查询自动转换
 */

@MappedTypes({Date.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyDateTypeHandler extends BaseTypeHandler<Date> {

    // 写数据库
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        System.out.println("test0");
        System.out.println("待转换数据:type:" + date.getClass().toString());
        System.out.println("待转换数据:data:" + date.toString());
        System.out.println("转换后:data:" + String.valueOf(date.getTime()));
        preparedStatement.setString(i, String.valueOf(date.getTime()));
    }

    // 读取转换
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("test1");
        System.out.println("读取字段:" + s);
        System.out.println("读取的数据:" + resultSet.getString(s));
        return new Date(resultSet.getLong(s));
    }

    // 读取转换
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("test2");
        System.out.println("读取的数据:" + i);
        return new Date(resultSet.getLong(i));
    }

    // 读取转换
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("test3");
        System.out.println("读取的数据:" + i);
        return callableStatement.getDate(i);
    }
}
