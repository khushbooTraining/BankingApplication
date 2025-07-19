package com.standalone.hello_bean;

import org.springframework.stereotype.Component;

@Component("hello")
public class HelloBean {
	
	public void sayHello() {
		System.out.println("hii khushboo bean");
	}

}
