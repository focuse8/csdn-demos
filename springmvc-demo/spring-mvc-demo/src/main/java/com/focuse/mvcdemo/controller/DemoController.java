package com.focuse.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @Resource
    private HttpServletRequest request;

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        System.out.println(request.getRequestURI());
        return "hello world!";
    }

    @ResponseBody
    @RequestMapping("hello3")
    public String hello(HttpServletRequest request3) {
        System.out.println(request3.getRequestURI());
        return "hello world!";
    }

}
