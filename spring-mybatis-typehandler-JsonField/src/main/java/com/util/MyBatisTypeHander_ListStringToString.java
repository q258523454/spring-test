package com.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


/*
    1.@MappedJdbcTypes定义的是JdbcType类型，这里的类型不可自己随意定义，必须要是枚举类org.apache.ibatis.type.JdbcType所枚举的数据类型。
    2.@MappedTypes定义的是JavaType的数据类型，描述了哪些Java类型可被拦截。
    3.在我们启用了我们自定义的这个TypeHandler之后，数据的读写都会被这个类所过滤
    4.在setNonNullParameter方法中，我们重新定义要写往数据库的数据。
    5.在另外三个方法中我们将从数据库读出的数据类型进行转换。
 */


@MappedTypes({List.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyBatisTypeHander_ListStringToString extends BaseTypeHandler<List<String>> {


    public void setNonNullParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        //1.List集合转字符串
        StringBuffer sb = new StringBuffer();
        for (String string : parameter) {
            sb.append(string).append(",");
        }
        //2.设置给ps
        System.out.println("List<String> 插入:List<String>:" + sb.toString().substring(0, sb.toString().length() - 1));
        ps.setString(i, sb.toString().substring(0, sb.toString().length() - 1));
    }

    public List<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("List<String> getNullableResult 1:columnName s=" + columnName);
        String[] split = rs.getString(columnName).split(",");
        return Arrays.asList(split);
    }

    public List<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("List<String> getNullableResult 2:columnIndex =" + columnIndex);
        String[] split = rs.getString(columnIndex).split(",");
        return Arrays.asList(split);
    }

    public List<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("List<String> getNullableResult 3: columnIndex =" + columnIndex);
        String[] split = cs.getString(columnIndex).split(",");
        return Arrays.asList(split);
    }
}
