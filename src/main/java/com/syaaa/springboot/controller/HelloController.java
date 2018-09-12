package com.syaaa.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author APPO
 * @Date 13:00   2018-9-10
 * @Version 1.0
 **/
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String sayHello(){
        return "Hello SpringBoot";
    }
}
