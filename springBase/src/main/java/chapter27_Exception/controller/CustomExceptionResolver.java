package chapter27_Exception.controller;

import chapter27_Exception.entity.CustomException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-28
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String msg;
        if (ex instanceof CustomException) {
            msg = ((CustomException) ex).getMsg();
        } else {
            msg = ex.getMessage();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", msg);
        modelAndView.setViewName("WEB-INF/jsp/exception/custom.jsp");
        return modelAndView;
    }
}
