package com.focuse.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/focuse")
public class DemoController {
    @Resource
    private HttpServletRequest request;

    @RequestMapping("hello")
    public String hello() {
        System.out.println(request.getRequestURI());
        return "hello world!";
    }

    @RequestMapping("hello3")
    public String hello3() {
        return "hello world!";
    }

}
