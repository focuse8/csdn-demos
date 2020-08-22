package com.focuse.webfluxdemo.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.netty.FutureMono;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/focuse")
public class DemoController {


    @RequestMapping("hello")
    public Mono<String> hello(@RequestParam(name = "name") String name) {
        System.out.println(System.currentTimeMillis() / 1000 + " start:" + name);
        CompletableFuture future = new CompletableFuture<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.parkNanos(3000000000l);
                future.complete(name + " " + System.currentTimeMillis() / 1000);
                System.out.println(System.currentTimeMillis() / 1000 + " end:" + name);
            }
        }).start();

        return FutureMono.fromFuture(future);
    }

    @RequestMapping("hellosyn")
    public String hellosyn(@RequestParam(name = "name") String name) {
        System.out.println("start:" + name);
        LockSupport.parkNanos(3000000000l);
        System.out.println("end:" + name);
        return name;
    }

}
