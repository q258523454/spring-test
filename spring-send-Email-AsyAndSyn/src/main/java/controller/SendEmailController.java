package controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.IEmailSender;

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

    @RequestMapping(value = "/sendEmail", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    String sendEmail(HttpServletRequest request, HttpSession session, HttpServletResponse response, String toEmail) {
        JSONObject object = new JSONObject();

        if (null == toEmail || toEmail.isEmpty()) {
            toEmail = "258523454@qq.com";
        }
        String content = "您好,这是一封测试邮件,如果非本人操作,请忽略.";
        String subject = "ZhJ 邮件测试";
        boolean flag = false;
        try {
            flag = sendEmail.send(null, toEmail, content, subject, true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        if (flag) {
            object.put("res", "发送成功.");
        } else {
            object.put("res", "发送失败.");
        }

        return object.toString();
    }


    @RequestMapping(value = "/sendAsyn", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    String sendAsyn(HttpServletRequest request, HttpSession session, HttpServletResponse response, String toEmail) {
        JSONObject object = new JSONObject();

        if (null == toEmail || toEmail.isEmpty()) {
            toEmail = "258523454@qq.com";
        }
        String content = "您好,这是一封测试邮件,如果非本人操作,请忽略.";
        String subject = "ZhJ 异步邮件测试";
        try {
            sendEmail.sendAsyn(null, toEmail, content, subject, true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

        object.put("res", "异步邮件已执行(成功不确定).");

        return object.toString();
    }
}
