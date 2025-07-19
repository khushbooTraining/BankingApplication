package com.khushboo.rest.webservices.restful_web_services.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



//Rest Api
@RestController
public class HelloWorldController {
   private MessageSource messageSource;
   
   public HelloWorldController(MessageSource messageSource) {
	   this.messageSource= messageSource;
   }
	
	// "Hello World"
	//@RequestMapping(method=RequestMethod.GET, path ="/hello-world")
	@GetMapping(path ="/hello-world")
	public String helloWorld(){
		return "Hello world";
		
	}
	
	@GetMapping(path ="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello world Bean");
		
	}
	
	//path parameter 
	///user/{id}/todo/{id}  =>/user/2/todo/400   2,400 is path parameter
	@GetMapping(path="/hello-World/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world Bean, %s", name));
	}
	
	@GetMapping(path ="/hello-world-internationalized")
	public String helloWorldInternationalized(){
		//example english- en
		//dutch -dutch - nl
		// french -fr
		//deutsch- de
	//	good.morning.message=Good Morning
		Locale locale=LocaleContextHolder.getLocale();
       return	messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//return "Hello world v2";
		
	}
}
