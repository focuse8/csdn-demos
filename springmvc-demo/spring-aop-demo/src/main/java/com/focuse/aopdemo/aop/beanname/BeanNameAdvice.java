package com.focuse.aopdemo.aop.beanname;

        import org.springframework.aop.MethodBeforeAdvice;
        import org.springframework.stereotype.Component;

        import java.lang.reflect.Method;

/**
 * @author ：
 * @date ：Created in 2020/8/22 下午3:00
 * @description：
 * @modified By：
 */
@Component
public class BeanNameAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("bean name autoproxy before");
    }
}
