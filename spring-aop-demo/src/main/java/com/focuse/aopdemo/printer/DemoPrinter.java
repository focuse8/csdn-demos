package com.focuse.aopdemo.printer;

import org.springframework.stereotype.Component;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:37
 * @description：
 * @modified By：
 */
@Component
public class DemoPrinter {
    private String name = "demoPrinter";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String print(String text) {
        return name + ":" + text;
    }

    private String printPri() {
        return name + "pri";
    }
}
