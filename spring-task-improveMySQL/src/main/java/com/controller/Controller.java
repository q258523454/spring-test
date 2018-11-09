package com.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    private Logger log = Logger.getLogger(Controller.class);


    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}