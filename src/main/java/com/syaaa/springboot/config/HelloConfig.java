package com.syaaa.springboot.config;

import com.syaaa.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HelloConfig
 * @Description TODO
 * @Author APPO
 * @Date 13:53   2018-9-12
 * @Version 1.0
 *
 * @Bean 相当于是spring注解中的<bean id= "">
 *
 * </bean>
 *id 为方法名称
 *
 * @Configuration 表明这是一个配置类
 *
 *
 **/
@Configuration
public class HelloConfig {

//    将方法的返回值添加到容器中，容器的id默认为方法名

    @Bean
    public HelloService getHelloService(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HelloService();
    }

}
