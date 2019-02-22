package com.util;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-05-15
 */

public class FastJsonSerializerUtil {

    public static class LongTest implements ObjectSerializer {
        public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            Long l = (Long) object;
            if (null == l) {
                jsonSerializer.write(l);
            } else {
                jsonSerializer.write("@JSONField测试_" + l);
            }
        }
    }
        public static class DateToStringYyyy_MM_dd implements ObjectSerializer {
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = (Date) object;
            String dateStr = null;
            if (null == date) {
                serializer.write(dateStr);
            } else {
                dateStr = simpleDateFormat.format(date);
                serializer.write(dateStr);
            }
        }
    }

    public static class StringToBigdecimal implements ObjectSerializer {
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            String value = (String) object;

            String regex = "^[1-9][0-9]*(.[0-9]*)?$";     // 必须是 金额型 字符串, 以 "0"开头的都不是金额型, 规则: 1-9开头,可含小数点
            Matcher m = Pattern.compile(regex).matcher(value);
            if (m.matches()) {
                BigDecimal bigDecimal = new BigDecimal(value);
                if (isIntegerValue(bigDecimal)) {
                    bigDecimal = bigDecimal.setScale(2);
                } else {
                    //TODO
                }
                serializer.write(bigDecimal);
            } else {
                // 如果不是金额型字符串, 保留原String格式, 不做任何处理
                serializer.write(value);
            }
        }
    }

    public static class BigdecimalFormat implements ObjectSerializer {
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            BigDecimal bigDecimal = (BigDecimal) object;
            if (isIntegerValue(bigDecimal)) {
                bigDecimal = bigDecimal.setScale(2);
            } else {
                //TODO
            }
            serializer.write(bigDecimal);
        }
    }

    public static class IntegerToBigDecimalFormat implements ObjectSerializer {
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            //  如果不是 Integer 类型整型
            if (!object.getClass().equals(Integer.class)) {
                serializer.write(object);
            } else {
                BigDecimal bigDecimal = new BigDecimal((Integer) object);
                if (isIntegerValue(bigDecimal)) {
                    bigDecimal = bigDecimal.setScale(2);
                } else {
                    //TODO
                }
                serializer.write(bigDecimal);
            }
        }
    }

    public static class IntegerToString implements ObjectSerializer {
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            Integer value = (Integer) object;
            String str = Integer.toString(value);
            serializer.write(str);
        }
    }

    public static class LongToString implements ObjectSerializer {
        public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
            Long value = (Long) object;
            String str = Long.toString(value);
            serializer.write(str);
        }
    }

    // 判断 BigDecimal 是不是一个整数值
    public static boolean isIntegerValue(BigDecimal bd) {
        // 注意: 100.00 也是属于整数, 小数后面是0的都会忽略
        return bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0;
    }
}
