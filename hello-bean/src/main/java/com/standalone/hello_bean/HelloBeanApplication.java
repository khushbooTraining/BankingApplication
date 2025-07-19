package com.standalone.hello_bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.standalone.hello_bean"})
public class HelloBeanApplication {

	public static void main(String[] args) {
		ApplicationContext ct= SpringApplication.run(HelloBeanApplication.class, args);
		HelloBean b=(HelloBean) ct.getBean("hello");
		//System.out.println(b);
		b.sayHello();
	}

}
