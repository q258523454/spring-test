package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    // @ResponseBody : 注解之后不会再走试图处理器，而是直接将数据写入到输入流, 下面会返回 /WEB-INF/views/index.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws Exception {
        return "DaGong";
    }

    @RequestMapping(value = "/test")
    public @ResponseBody
    String test() throws Exception {
        return "success";
    }

    // application/json; charset=UTF-8 防止中文乱码
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String user(Model model) {
        User user = userService.selectUserByIdOrg(9);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        model.addAttribute("userlist", userList);
        return "use" + "rlist";
    }

    // application/json; charset=UTF-8 防止中文乱码
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String list(Model model) {
        List<User> userList = userService.selectAllUserOrg();
        model.addAttribute("userlist", userList);
        return "use" + "rlist";
    }

    // application/json; charset=UTF-8 防止中文乱码
    @RequestMapping(value = "/user2", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String user2(Model model) {
        User user = userService.selectUserByIdPro(9);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        model.addAttribute("userlist", userList);
        return "use" + "rlist";
    }

    // application/json; charset=UTF-8 防止中文乱码
    @RequestMapping(value = "/list2", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String list2(Model model) {
        List<User> userList = userService.selectAllUserPro();
        model.addAttribute("userlist", userList);
        return "use" + "rlist";
    }
}