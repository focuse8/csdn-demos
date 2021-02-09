package com.focuse.mvcdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ：
 * @date ：Created in 2020/11/30 上午11:18
 * @description：
 * @modified By：
 */
@Configuration
@ComponentScan(basePackages = {"com.focuse.mvcdemo"})
@EnableWebMvc
//@ImportResource("classpath*:spring/servlet-context.xml")
public class ApplicationConfig {
}
