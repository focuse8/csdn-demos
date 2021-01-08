package com.focuse.modelattributedemo.controller;

import com.focuse.modelattributedemo.core.TestModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@Controller
@RequestMapping("/focuse")
public class DemoController {

    @ResponseBody
    @RequestMapping("hello")
    public String hello(@ModelAttribute(name = "test", binding = true) TestModelAttribute input) {
        return "hello world!";
    }

}
