package com.syaaa.springboot;

import com.syaaa.springboot.vo.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

	@Test
	public void testHelloService(){
		System.out.println(ioc.containsBean("getHelloService"));
	}

}
