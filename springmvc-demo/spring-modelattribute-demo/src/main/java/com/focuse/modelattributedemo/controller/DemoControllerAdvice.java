package com.focuse.modelattributedemo.controller;

import com.focuse.modelattributedemo.core.TestModelAttribute;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author ：
 * @date ：Created in 2021/1/2 4:44 PM
 * @description：
 * @modified By：
 */
@ControllerAdvice
public class DemoControllerAdvice {


    @ModelAttribute(name="test", binding = false)
    public TestModelAttribute testInitModel() {
        TestModelAttribute result = new TestModelAttribute();

        result.setTestName("testName");
        result.setTestSource("H5");

        return result;
    }


    @ModelAttribute
    public void testInitModel(ModelMap model) {
        model.put("test1", "value1");
        model.put("test2", "value2");
        model.put("test3", "value3");
    }

}
