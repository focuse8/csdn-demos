package com.focuse.aopdemo.aop.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author ：
 * @date ：Created in 2020/8/22 下午4:18
 * @description：
 * @modified By：
 */
@Component
public class DemoAdvisor implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("advisor method interceptor");
        return invocation.proceed();
    }
}
