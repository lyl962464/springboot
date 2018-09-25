package com.syaaa.springboot.controller;

import com.syaaa.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author APPO
 * @Date 13:00   2018-9-10
 * @Version 1.0
 **/
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String sayHello(@PathVariable("user") String user)
    {
        if("aaa".equals(user)){
            throw  new UserNotExistException();
        }
        return "";
    }

}
