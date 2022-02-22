package chapter27_Interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-28
 */
@Controller
public class LoginController {

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "WEB-INF/jsp/login/login.jsp";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) {
        // 把用户信息保存到session中
        session.setAttribute("username", username);
        return "index.jsp";
    }

    // 退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //清空session
        session.invalidate();
        // 重定向到登录页面
        return "redirect:/loginPage";
    }
}
