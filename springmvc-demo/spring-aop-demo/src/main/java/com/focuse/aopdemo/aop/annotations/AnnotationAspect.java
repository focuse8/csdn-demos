package com.focuse.aopdemo.aop.annotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author ：
 * @date ：Created in 2020/8/22 下午12:29
 * @description：
 * @modified By：
 */
@Component
//@EnableAspectJAutoProxy
//@Aspect
public class AnnotationAspect {

    @Around("target(com.focuse.aopdemo.printer.Printer")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("annotation around before");
        Object retVal = pjp.proceed();
        System.out.println("annotation around after");
        return retVal;
    }
}
