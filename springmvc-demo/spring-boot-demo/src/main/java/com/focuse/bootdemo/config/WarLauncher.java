package com.focuse.bootdemo.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ：
 * @date ：Created in 2020/11/30 下午1:39
 * @description：
 * @modified By：
 */
public class WarLauncher extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(Launcher.class);
        return builder;
    }
}
