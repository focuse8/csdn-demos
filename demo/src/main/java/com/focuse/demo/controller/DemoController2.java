package com.focuse.demo.controller;

import com.focuse.demo.printer.DemoPrinter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/focuse")
@Configuration
@ComponentScan(basePackages = "com.focuse.demo")
public class DemoController {

    @Resource
    private  DemoPrinter demoPrinter;

    @RequestMapping("hello")
    public String hello() {
        return demoPrinter.getText();
    }

}
