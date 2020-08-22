package com.focuse.dynamicdemo.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author ：
 * @date ：Created in 2020/8/8 下午10:27
 * @description：
 * @modified By：
 */
public class LocalPrinterCallback implements MethodInterceptor {

    Object target;

    public LocalPrinterCallback(Object target) {
        this.target = target;
    }
    //代理
    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,
                            MethodProxy proxy) throws Throwable{
        try {
            System.out.println("before advice");
            //请求目标对象方法
            Object ret = method.invoke(target, args);
            System.out.println("after advice");
            return ret;
        }finally {
            System.out.println("finally advice");
        }
    }

}
