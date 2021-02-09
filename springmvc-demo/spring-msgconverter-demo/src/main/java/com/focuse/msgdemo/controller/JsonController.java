package com.focuse.msgdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author ：
 * @date ：Created in 2020/5/15 下午11:56
 * @description：
 * @modified By：
 */
@Controller
@RequestMapping("/focuse/json")
public class JsonController {

    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    {
        ObjectMapper objectMapper = new ObjectMapper();
        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
    }

    private StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();

    @ResponseBody
    @RequestMapping("hello")
    public JsonTest hello(HttpServletRequest request) {

        JsonTest test = null;
        try {
            String head = request.getHeader("Content-Type");
            MediaType mediaType = MediaType.parseMediaType(head);

            if (mappingJackson2HttpMessageConverter.canRead(JsonTest.class, mediaType)) {
                ServletServerHttpRequest serverHttpRequest = new ServletServerHttpRequest(request);
                test = (JsonTest) mappingJackson2HttpMessageConverter.read(JsonTest.class, serverHttpRequest);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }

    public static void main(String[] args){
        Class c = A.class.getSuperclass();
        Type[] a = A.class.getSuperclass().getTypeParameters();
        //Type[] b= ((ParameterizedType) a).getActualTypeArguments();
        System.out.println();
    }
}

class A extends ArrayList<String> {

}
