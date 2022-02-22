package chapter27_Exception.controller;

import chapter27_Exception.entity.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-28
 */
@Controller
public class ExceptionTestController {


    @RequestMapping(value = "/exception")
    public String exception(Model model) throws CustomException {
        Random random = new Random();
        int r = random.nextInt(10);
        String test;
        if (r > 5) {
            test = "1";
        } else {
            test = "2";
        }
        // 抛出一个自定义异常
        if ("1".equals(test)) {
            throw new CustomException("这是一个自定义CustomException异常！");
        }
        model.addAttribute("msg", "It is Ok!");
        return "WEB-INF/jsp/exception/custom.jsp";
    }
}