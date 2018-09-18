package com.syaaa.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author APPO
 * @Date 13:03   2018-9-18
 * @Version 1.0
 **/
@Controller
public class LoginController {


        @PostMapping(value = "/user/login")
        public String login(@RequestParam("username")String username,
                            @RequestParam("password")String password, Map<String,Object> map, HttpSession session){

            if (!StringUtils.isEmpty(username) && "123".equals(password)) {
//                登录成功之后，重定向到指定的页面，防止重复提交
                session.setAttribute("loginUser",username);
                return "redirect:/main.html";
            } else {
                map.put("msg", "用户名或密码错误");
                return "login";
            }
        }
}
