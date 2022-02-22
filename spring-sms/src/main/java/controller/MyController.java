package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.sendSMS.SmsSender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-25
 */

@Controller
public class MyController {
    @Autowired
    private SmsSender smsSender;

    @RequestMapping(value = "/sendSMS", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    String sendSMS(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String telephone = "";
        if (telephone.isEmpty() || null == telephone) {
            telephone = "13266846736";
        }

        // 生成短信验证码
        String code = "";
        Random random = new Random();  //创建随机数生成器
        for (int i = 0; i < 6; i++) {
            String strRand = String.valueOf(random.nextInt(10));
            code = code + strRand;
        }
        try {
            smsSender.sendSMS(telephone, code, "120");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "验证码: "+code;
    }
}
