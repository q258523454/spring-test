package util.sendSMS.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import util.StringMD5;
import util.sendSMS.SmsSender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * @author zhang
 */
@Service
public class SmsSenderImpl implements SmsSender {

    private static final Logger logger = LogManager.getLogger(SmsSenderImpl.class);

    public final static String CHINA_CODE = "86";

    @Value("${sms.sdk.app.id}")
    private int sdkAppId;

    @Value("${sms.app.key}")
    private String appKey;

    @Value("${sms.send.sms.url}")
    private String sendSmsUrl;


    // 检查短信发送结果
    private static boolean checkSmsResult(String result) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // objectMapper.readValue 将字符串转换成object对象类
            Map<String, Object> res = objectMapper.readValue(result, HashMap.class);
            if ("0".equals(res.get("result"))) {
                return true;
            } else {
                logger.error("" + res.get("errmsg"));
            }
        } catch (IOException e) {
            logger.info(String.format("jackson parse %s error", result), e);
        }
        return false;
    }


    /**
     * @param nationCode  国家码
     * @param phoneNumber 不带国家码的手机号
     * @param content     发送内容，必须与申请的模板格式一致，否则将返回错误
     */
    public boolean sendSmsUtil(String nationCode, String phoneNumber, String content) throws Exception {

        if (StringUtils.isEmpty(nationCode)) {
            nationCode = CHINA_CODE;
        }

        if (StringUtils.isEmpty(phoneNumber)) {
            throw new IllegalArgumentException("phoneNumber cannot be null");
        }

        Random random = new Random();
        long rnd = random.nextInt(999999) % (999999 - 100000 + 1) + 100000;     // 腾讯短信购买时的例子 测试时rnd=123456也可发送短信
        String wholeUrl = String.format("%s?sdkappid=%d&random=%d", sendSmsUrl, sdkAppId, rnd);

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {
            URL object = new URL(wholeUrl);
            HttpURLConnection con = (HttpURLConnection) object.openConnection();

            con.setDoOutput(true);
            con.setDoInput(true);

            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");

            Map<String, Object> tel = new HashMap<String, Object>();
            tel.put("nationcode", nationCode);  // 非必须
            tel.put("phone", phoneNumber);      // *必须

            Map<String, Object> data = new HashMap();
            String sig = StringMD5.getStrMD5(appKey.concat(phoneNumber)); // 腾讯短信接口的请求发送sig字段加密策略
            data.put("tel", tel);       // *必须
            data.put("msg", content);   // *必须
            data.put("sig", sig);       // *必须

            ObjectMapper objectMapper = new ObjectMapper();
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream(), "utf-8");
            wr.write(objectMapper.writeValueAsString(data)); // objectMapper.writeValueAsString(data) 将data--> {json格式}
            wr.flush(); // 缓冲区中的数据保存直到缓冲区满后才写出，也可以使用flush方法将缓冲区中的数据强制写出

            // 显示 POST 请求返回的内容
            int HttpResult = con.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) { // HTTP_OK=200
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                logger.info(String.format("sendSms %s, %s, %s, with result %s", nationCode, phoneNumber, content, sb.toString()));
                return checkSmsResult(sb.toString());
            } else {
                logger.info(String.format("sendSms %s, %s, %s, http status do not return ok", nationCode, phoneNumber, content));
                return false;
            }
        } catch (Exception e) {
            logger.info(String.format("sendSms %s, %s, %s, exception", nationCode, phoneNumber, content), e);
        } finally {
            IOUtils.closeQuietly(br);
        }
        return false;
    }


    @Override
    public boolean sendSMS(String telephone, String code, String timeout) throws Exception {
        // content发送内容，必须与申请的模板格式一致，否则将返回错误
        String content = String.format("%s为您的登录验证码，请于%s秒内填写。如非本人操作，请忽略本短信", code, timeout);
        boolean flag = sendSmsUtil(null, telephone, content);
        return flag;
    }
}

