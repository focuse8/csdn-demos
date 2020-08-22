package com.focuse.dynamicdemo.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author ：
 * @date ：Created in 2020/8/8 下午4:29
 * @description：
 * @modified By：
 */
public class JdkDynamicDemo {

    public static void main(String... args) {
        LocalWriterPrinter target= new LocalWriterPrinter();
        WriterPrinterInvocationHandler handler = new WriterPrinterInvocationHandler(target);
        Class<?>[] infs = {Printer.class, WriterPrinter.class, Writer.class};
        Object writerPrinter = Proxy.newProxyInstance(JdkDynamicDemo.class.getClassLoader(), infs, handler);
        Printer printer = (Printer)writerPrinter;
        printer.print("jdk dynamic");

        Writer writer = (Writer) writerPrinter;
        writer.write("jdk dynamic");
    }
}
