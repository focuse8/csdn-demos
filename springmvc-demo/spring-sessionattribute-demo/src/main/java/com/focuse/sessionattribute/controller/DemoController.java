package com.focuse.sessionattribute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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

    @RequestMapping("hello2")
    public String hello2(Model model) {
         String sessionAttr1 = (String) model.getAttribute("sessionAttr1");
         return "/focuse/hello3";
    }

    @ResponseBody
    @RequestMapping("hello3")
    public String hello3(Model model) {

        return "hello world!";
    }

    @RequestMapping("hello4")
    public String hello4(Model model, SessionStatus status) {
        status.setComplete();

        return "/focuse/hello3";
    }

}
