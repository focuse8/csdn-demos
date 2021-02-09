package com.focuse.dubboconsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@Controller
@RequestMapping("/focuse")
@SessionAttributes(names = {"sessionAttr1"})
public class DemoController {

    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("sessionAttr1", "sessionAttr1Val");
        return "/focuse/hello3";
    }

}
