package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.CheckCodeUtil;

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
public class MyController {

    // 获取图片验证码测试
    @RequestMapping("/getCheckImageTest")
    @ResponseBody
    public void getCheckImageTest(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        // 一般通过cookies得到cookies中指定name的sessionId, 图片验证刷新操作和生成都与本次session绑定
        String imgCode = CheckCodeUtil.createImage(request, response);//生成图片验证码
    }
}
