package com.focuse.springschema.controller;

import com.focuse.springschema.printer.StringPrinter;
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
public class SpringController {
    @Resource
    private StringPrinter stringPrinter;

    @RequestMapping("hello")
    public String hello() {
        return stringPrinter.getText();
    }

}
