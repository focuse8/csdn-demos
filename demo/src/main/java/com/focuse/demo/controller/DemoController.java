package com.focuse.demo.controller;

import com.focuse.demo.printer.DemoPrinter;
import com.focuse.demo.DemoPrinterAware;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/focuse")
@Import(DemoPrinterAware.class)
public class DemoController {

    @Resource
    private HttpServletRequest request;

    @RequestMapping("hello")
    public String hello() {
        System.out.println(request.getRequestURI());
        return "hello world!";
    }

    @RequestMapping("hello3")
    public String hello(HttpServletRequest request3) {
        System.out.println(request3.getRequestURI());
        return "hello world!";
    }

}
