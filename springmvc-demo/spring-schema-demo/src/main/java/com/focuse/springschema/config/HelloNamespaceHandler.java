package com.focuse.springschema.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:29
 * @description：
 * @modified By：
 */
public class HelloNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("print", new HelloBeanDefinitionParser());
    }
}
