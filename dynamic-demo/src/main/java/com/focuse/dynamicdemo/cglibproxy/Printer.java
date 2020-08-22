package com.focuse.dynamicdemo.cglibproxy;

/**
 * @author ：
 * @date ：Created in 2020/8/8 下午10:12
 * @description：
 * @modified By：
 */
public class Printer {

    public String print(String text) {
        System.out.println("Local Printer:" + text);
        return text;
    }

    protected String print22(String text) {
        System.out.println("Local Printer:" + text);
        return text;
    }

    private String print33(String text) {
        System.out.println("Local Printer:" + text);
        return text;
    }
}
