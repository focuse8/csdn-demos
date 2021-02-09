package com.focuse.mvcdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author ：
 * @date ：Created in 2020/11/30 上午11:13
 * @description：
 * @modified By：
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        Class[] result = new Class[1];
        result[0] = ApplicationConfig.class;
        return result;
    }

    protected String[] getServletMappings() {
        String[] result = new String[1];
        result[0] = "/*";
        return result;
    }
}
