package com.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
    1.@MappedJdbcTypes定义的是JdbcType类型，这里的类型不可自己随意定义，必须要是枚举类org.apache.ibatis.type.JdbcType所枚举的数据类型。
    2.@MappedTypes定义的是JavaType的数据类型，描述了哪些Java类型可被拦截。
    3.在我们启用了我们自定义的这个TypeHandler之后，数据的读写都会被这个类所过滤
    4.在setNonNullParameter方法中，我们重新定义要写往数据库的数据。
    5.在另外三个方法中我们将从数据库读出的数据类型进行转换。
 */

@MappedTypes({Date.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class MyBatisTypeHander_DateToString extends BaseTypeHandler<Date> {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    // 插入:数据转换后插入数据库
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        String insertSql = simpleDateFormat.format(date);
        preparedStatement.setString(i, insertSql);
    }

    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String strFromSQL = rs.getString(columnName);
        Date date = null;
        try {
            date = simpleDateFormat.parse(strFromSQL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String strFromSQL = rs.getString(columnIndex);
        Date date = null;
        try {
            date = simpleDateFormat.parse(strFromSQL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String strFromSQL = cs.getString(columnIndex);
        Date date = null;
        try {
            date = simpleDateFormat.parse(strFromSQL);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
