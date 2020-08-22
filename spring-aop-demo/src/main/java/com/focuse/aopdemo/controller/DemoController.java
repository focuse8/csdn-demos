package com.focuse.aopdemo.controller;

import com.focuse.aopdemo.printer.DemoPrinter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
public class DemoController {

    @Resource
    private  DemoPrinter demoPrinter;

    @RequestMapping("hello")
    public String hello(@RequestParam("text") String text) {
        return demoPrinter.print(text);
    }

    @RequestMapping("hello_pri")
    private String helloPri(@RequestParam("text") String text) {
        return demoPrinter.print(text);
    }
}
