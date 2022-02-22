package chapter27_Interceptor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-28
 */
public class LoginInterceptor implements HandlerInterceptor {

    // Handler执行前调用
    // 应用场景：登录认证、身份授权
    // 返回值为true则是放行，为false是不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URI

        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        // 1.如果请求的URL是公开地址（无需登录就可以访问的URL），采取放行。
        if ("/loginPage".equals(requestURI)) {
            return true;
        }
        // 2.如果用户session存在，则放行。
        Object username = request.getSession().getAttribute("username");
        if (username != null && !username.equals("")) {
            return true;
        }
        // 3.如果用户session中不存在，则跳转到登录页面。
        response.sendRedirect("/loginPage");
        return false;
    }

    // 进入Handler开始执行，并且在返回ModelAndView之前调用
    // 应用场景：对ModelAndView对象操作，可以把公共模型数据传到前台，可以统一指定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    // 执行完Handler之后调用
    // 应用场景：统一异常处理、统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
