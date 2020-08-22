package com.focuse.dynamicdemo.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：
 * @date ：Created in 2020/7/18 下午9:37
 * @description：
 * @modified By：
 */
public class WriterPrinterInvocationHandler implements InvocationHandler {

    private Object printer;

    public WriterPrinterInvocationHandler(Object writerPrinter) {
        this.printer = writerPrinter;
    };

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println("before advice:" + method.getDeclaringClass().getSimpleName() + "." + method.getName());
            Object ret = method.invoke(printer, args);
            System.out.println("after advice:" + method.getDeclaringClass().getSimpleName() + "." + method.getName());
            return ret;
        } finally {
            System.out.println("finally advice:" + method.getDeclaringClass().getSimpleName() + "." +  method.getName());
        }
    }
}
