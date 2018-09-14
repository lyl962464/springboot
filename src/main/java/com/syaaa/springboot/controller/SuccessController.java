package com.syaaa.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName SuccessController
 * @Description TODO
 * @Author APPO
 * @Date 12:31   2018-9-14
 * @Version 1.0
 **/
@Controller
public class SuccessController {

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>hello</h1>");

        map.put("users", Arrays.asList("张三","李四"));
        return "success";
    }


}
