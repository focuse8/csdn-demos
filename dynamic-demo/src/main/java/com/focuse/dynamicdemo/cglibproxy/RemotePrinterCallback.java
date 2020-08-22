package com.focuse.dynamicdemo.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author ：
 * @date ：Created in 2020/8/8 下午10:27
 * @description：
 * @modified By：
 */
public class RemotePrinterCallback implements MethodInterceptor {

    Object target;

    public RemotePrinterCallback(Object target) {
        this.target = target;
    }
    //代理
    public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args,
                            MethodProxy proxy) throws Throwable{
        try {
            System.out.println("remote before advice");
            //请求目标对象方法
            Object ret = method.invoke(target, args);
            System.out.println("remote after advice");
            return ret;
        }finally {
            System.out.println("remote finally advice");
        }
    }

}
