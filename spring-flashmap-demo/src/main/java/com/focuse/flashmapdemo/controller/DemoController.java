package com.focuse.flashmapdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

    @RequestMapping("hello")
    public String hello(RedirectAttributes redirectAttributes, HttpServletRequest request) {

        redirectAttributes.addFlashAttribute("flashdemo", "'hello world!' from " + request.getRequestURI());

        return "redirect:/focuse/hello3";
    }

    @ResponseBody
    @RequestMapping("hello3")
    public String hello(ModelMap model) {
        return String.valueOf(model.getAttribute("flashdemo"));
    }

}
