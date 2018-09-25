package com.syaaa.springboot.controller;

import com.syaaa.springboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyExceptionHandler 定义异常处理类
 * @Description TODO
 * @Author APPO
 * @Date 17:09   2018-9-21
 * @Version 1.0
 *
 *@ControllerAdvice 用来自定义处理异常的类
 * 通常和@ResponseBody   @ExceptionHandler(UserNotExistException.class)使用
 *
 *
 *
 *
 *
 *
 **/

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user not exsits");
//        map.put("message", e.getMessage());
//        return map;
//    }


    @ExceptionHandler({UserNotExistException.class})
    public String handleException(Exception e,HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
//        设置返回的状态码

        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code", "user not exsits");
        map.put("message", e.getMessage());
        return "forward:/error";
    }

}
