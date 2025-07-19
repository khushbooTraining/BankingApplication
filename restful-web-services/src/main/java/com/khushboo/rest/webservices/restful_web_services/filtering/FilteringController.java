package com.khushboo.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filter")
	public Exam filtering() {
		
		return new Exam("v1","v2","v3");
	}
	
	//static filter
	@GetMapping(path="/filterlist")
    public List<Exam> filterList(){
		
		return Arrays.asList( new Exam("khushboo","Madhu","rakhi"),new Exam("1","2","3"));
		
	}
	
	//Dynamic filter for diff rest api using MappingJacksonValue
	@GetMapping(path="/filtering1")
	public MappingJacksonValue filtering1() {
		Exam exam=new Exam("khushboo","Madhu","rakhi");
		
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(exam);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("v1","v2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("ExamFilter", filter );
		 mappingJacksonValue.setFilters(filters);
		 return mappingJacksonValue;
	}
	
	@GetMapping(path="/filtering2")
	public MappingJacksonValue filtering2() {
		Exam exam=new Exam("khushboo","Madhu","rakhi");
		
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(exam);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("v1","v3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("ExamFilter", filter );
		 mappingJacksonValue.setFilters(filters);
		 return mappingJacksonValue;
	}
}
