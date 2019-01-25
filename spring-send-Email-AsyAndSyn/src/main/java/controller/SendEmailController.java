package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.IEmailSender;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-25
 */

@Controller
public class SendEmailController {

    @Autowired
    IEmailSender sendEmail;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
    public @ResponseBody
    String sendEmail(HttpServletRequest request, HttpSession session, HttpServletResponse response, String toEmail) {

        if (null == toEmail || toEmail.isEmpty()) {
            toEmail = "258523454@qq.com";
        }
        String content = "您好,这是一封测试邮件,如果非本人操作,请忽略.";
        String subject = "ZhJ 邮件测试";
        try {
            sendEmail.send(null, toEmail, content, subject, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject object = new JSONObject();
        object.put("res", "ok"); // 设置有效时间为120s
        return object.toString();
    }
}
