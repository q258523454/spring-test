package chapter22_MVC.controller;

import chapter22_MVC.entity.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-25
 */

@Controller
public class GoodsController {

    @RequestMapping(value = "/queryGoods")
    public ModelAndView queryGoods() {

        ModelAndView modelAndView = new ModelAndView();

        List<Goods> goodsList = new ArrayList<>();
        Goods goods1 = new Goods();
        goods1.setName("a");
        goods1.setPrice(100.0D);
        goods1.setDetail("A");

        Goods goods2 = new Goods();
        goods2.setName("b");
        goods2.setPrice(1.2D);
        goods2.setDetail("B");

        goodsList.add(goods1);
        goodsList.add(goods2);

        // 设置数据和视图
        modelAndView.addObject("goodsList", goodsList);
        modelAndView.setViewName("/WEB-INF/jsp/goodsList.jsp");

        return modelAndView;
    }

}
