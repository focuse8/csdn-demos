package com.focuse.aopdemo.aop.xmlbase;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author ：
 * @date ：Created in 2020/8/22 下午12:29
 * @description：
 * @modified By：
 */
@Component
public class DemoAspect{

    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before");
        Object retVal = pjp.proceed();
        System.out.println("around after");
        return retVal;
    }
}
