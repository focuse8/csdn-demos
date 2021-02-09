package com.focuse.dynamicdemo.cglibproxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：
 * @date ：Created in 2020/8/8 下午10:07
 * @description：
 * @modified By：
 */
public class CglibDynamicDemo {

    public static void main(String... args) {
        //目标对象
        Printer target = new Printer();
        //callback  目标对象作为其成员变量
        LocalPrinterCallback localCallback = new LocalPrinterCallback(target);
        //创建enhancer类
        Enhancer enhancer = new Enhancer();
        //设置需要增强的类Printer
        enhancer.setSuperclass(Printer.class);
        //设置callback 相当于jdk动态代理的InvocationHandler
        enhancer.setCallback(localCallback);
        //创建代理类并返回代理对象
        Object object = enhancer.create();
        Printer proxy = (Printer)object;
        //执行print方法
        proxy.print("cglib demo");
    }
}
