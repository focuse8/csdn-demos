package com.focuse.msgdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ：
 * @date ：Created in 2020/11/30 上午11:18
 * @description：
 * @modified By：
 */
@Configuration
@ComponentScan(basePackages = {"com.focuse.msgdemo"})
@EnableWebMvc
public class ApplicationConfig {
}
