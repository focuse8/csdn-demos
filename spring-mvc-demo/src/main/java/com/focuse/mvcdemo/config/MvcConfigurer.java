package com.focuse.mvcdemo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class MvcConfigurer implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration logInterceptor = registry.addInterceptor(new LogInterceptor());
        logInterceptor.addPathPatterns("/focuse/hello");
    }
}
