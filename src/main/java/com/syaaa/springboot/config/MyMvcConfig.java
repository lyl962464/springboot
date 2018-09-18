package com.syaaa.springboot.config;

import com.syaaa.springboot.compent.LoginHandlerInterrupter;
import com.syaaa.springboot.compent.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Locale;

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
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/view").setViewName("success");

//        配置指定的登录界面
        /**
         * 还可以在控制类中指定的方法进行指定页面下的跳转
         *
         */
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/index.htm").setViewName("login");
    }
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter  = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                /*指定拦截的路径，并排除不需要拦截的路径*/
               registry.addInterceptor(new LoginHandlerInterrupter()).addPathPatterns("/**").excludePathPatterns("/index.html","index.htm","/user/login");
            }
        };
        return adapter;
    }


    /***
     * 替换WebMvcAutoConfig中的 localeResolver
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
       return new MyLocalResolver();
    }
}
