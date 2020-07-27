package com.focuse.springschema.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:32
 * @description：
 * @modified By：
 */
public class HelloBeanDefinitionParser implements BeanDefinitionParser {
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String text = element.getAttribute("text");
        GenericBeanDefinition bd = new GenericBeanDefinition();
        bd.setScope("singleton");//单例
        bd.setBeanClassName("com.focuse.springschema.annotationcomps.StringPrinter");
        bd.getPropertyValues().add("text", text); //设置属性
        parserContext.getRegistry().registerBeanDefinition("com.focuse.springschema.annotationcomps.StringPrinter", bd);
        return bd;
    }
}
