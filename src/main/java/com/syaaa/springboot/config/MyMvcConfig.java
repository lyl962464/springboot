package com.syaaa.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MyMvcConfig
 * @Description TODO @EnableWebMvc是取消SpringBoot 对 SpringMVC 的全面支持，需要采用自己写的配置类
 *
 * TODO  Spring2.0中的 WebMvcConfigurerAdapter过时，采用 implements WebMvcConfigurer实现测试
 *
 *
 *
 *
 * @Author APPO
 * @Date 9:27   2018-9-17
 * @Version 1.0
 **/

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/view").setViewName("success");
    }
}
