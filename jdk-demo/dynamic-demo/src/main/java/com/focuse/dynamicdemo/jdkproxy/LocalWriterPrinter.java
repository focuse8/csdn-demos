package com.focuse.dynamicdemo.jdkproxy;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:37
 * @description：
 * @modified By：
 */
public class LocalWriterPrinter implements Writer, Printer, WriterPrinter {
    public String print(String text) {
         System.out.println(this.getClass().getSimpleName() + " print:" + text);
         return text;
    }

    public String write(String text) {
        System.out.println(this.getClass().getSimpleName() + " write:" + text);
        return text;
    }
}
