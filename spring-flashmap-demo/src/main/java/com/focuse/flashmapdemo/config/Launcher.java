package com.focuse.flashmapdemo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author ：
 * @date ：Created in 2020/11/30 下午1:36
 * @description：
 * @modified By：
 */
@SpringBootApplication(exclude = {DispatcherServletAutoConfiguration.class})
@Import(ApplicationConfig.class)
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class);
    }

    @Bean
    public DispatcherServlet dispatchServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        return dispatcherServlet;
    }

    @Bean
    public DispatcherServletRegistrationBean dispatchServletBean(DispatcherServlet dispatcherServlet) {
        DispatcherServletRegistrationBean dispatchServletBean = new DispatcherServletRegistrationBean(dispatcherServlet, "");
        dispatchServletBean.setLoadOnStartup(1);
        return dispatchServletBean;
    }
}
