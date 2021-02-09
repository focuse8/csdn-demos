package com.focuse.demo.controller;

<<<<<<< HEAD:demo/src/main/java/com/focuse/demo/controller/DemoController.java
import com.focuse.demo.DemoPrinterAware;
import org.springframework.context.annotation.Import;
=======
>>>>>>> d937decc1b7e4ad68a377fa6a9f871846dd62baa:spring-xmlmvc-demo/src/main/java/com/focuse/demo/controller/DemoController.java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
<<<<<<< HEAD:demo/src/main/java/com/focuse/demo/controller/DemoController.java
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;
=======
>>>>>>> d937decc1b7e4ad68a377fa6a9f871846dd62baa:spring-xmlmvc-demo/src/main/java/com/focuse/demo/controller/DemoController.java

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/focuse")
public class DemoController {
    @Resource
    private HttpServletRequest request;

    private int index = 0;

    @RequestMapping("hello")
    public String hello() {
        Object object = request.getAttribute("focuse.test.async");
        AsyncContext asyncContext;
        if (object != null) {
            asyncContext = (AsyncContext)object;
        } else {
            asyncContext = request.startAsync();
            request.setAttribute("focuse.test.async", asyncContext);
        }
        asyncContext.dispatch("/focuse/hello3");
        System.out.println(request.getRequestURI());
        return "hello world!";
    }

    @RequestMapping("hello3")
<<<<<<< HEAD:demo/src/main/java/com/focuse/demo/controller/DemoController.java
    public String hello(HttpServletRequest request3) {

        Object object = request.getAttribute("focuse.test.async");
        AsyncContext asyncContext; //= request.startAsync();
//        if (object != null) {
            asyncContext = (AsyncContext)object;
            asyncContext.getRequest().startAsync();
            if (index > 10) {
                asyncContext.complete();
                return "hello focse";
            }
            asyncContext.dispatch();
        //}
        index++;
        System.out.println(request3.getRequestURI());
        return "hello world3!";
=======
    public String hello3() {
        return "hello world!";
>>>>>>> d937decc1b7e4ad68a377fa6a9f871846dd62baa:spring-xmlmvc-demo/src/main/java/com/focuse/demo/controller/DemoController.java
    }

    public static void main(String[] arges) throws Exception{



        ParameterizedType e = (ParameterizedType)(A.class.getDeclaredField("e").getGenericType());
        Type[] f =  ((WildcardType)(e.getActualTypeArguments()[0])).getUpperBounds();

        System.out.println("asdf");
    }

}

class A {
    private <T extends Number & Comparable > T a() {
        return null;
    };
}


