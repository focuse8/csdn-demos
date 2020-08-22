package com.focuse.webfluxdemo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author ：
 * @date ：Created in 2020/8/19 下午5:21
 * @description：
 * @modified By：
 */
@SpringBootApplication(scanBasePackages = {"com.focuse.webfluxdemo.server"})
@EnableWebFlux
public class Launcher {
    public static void main(String... args) {
        SpringApplication.run(Launcher.class, args);
    }
}
