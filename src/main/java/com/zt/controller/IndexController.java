package com.zt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zhangtong
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }




}
