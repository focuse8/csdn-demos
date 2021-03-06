package com.focuse.componentscandemo.controller;


import com.focuse.componentscandemo.annotationcomps.AnnotationPrinter;
import com.focuse.componentscandemo.xmlcomps.XmlPrinter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@ComponentScan(basePackages = {"com.focuse.componentscandemo.annotationcomps"})
public class DemoConfiguration {

    @Resource
    private XmlPrinter xmlPrinter;

    @Resource
    private AnnotationPrinter annotationPrinter;

    @RequestMapping("hello")
    public String hello(String printer) {
        if ("xml".equals(printer)) {
            return xmlPrinter.getText();
        } else if ("annotation".equals(printer)) {
            return annotationPrinter.getText();
        }

        return "invalid param";
    }

}
