package com.khushboo.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	//URI Versioning   http://localhost:80808/v1/person
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstPersonOfPerson() {
		return new PersonV1("Khushboo kumari");
	}

	
	@GetMapping("/v2/person")
	public PersonV2 getSecondPersonOfPerson() {
		return new PersonV2(new Name("khushboo", "kumari"));
	}
	
	
	@GetMapping(path="/person/param", params="version=2")
	public PersonV2 getSecondPersonOfPersonRequestParameter() {
		return new PersonV2(new Name("khushboo", "kumari"));
	}
	
//request parameter versioning   http://localhost:8080/person?version=1
	@GetMapping(path="/person/param", params="version=1")
	public PersonV1 getFirstPersonOfPersonRequestParam() {
		return new PersonV1("Khushboo kumari");
	}
	
	
	//accept header versioning   http://localhost:8080/person/header  //header name-X-API-VERSION, value=1
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getFirstPersonOfPersonAcceptHeaderParam() {
		return new PersonV1("Khushboo kumari");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getSecondPersonOfPersonAcceptHeaderParam() {
		return new PersonV2(new Name("khushboo", "kumari"));
	}
	
	
	//http://localhost:8080/person/header  name- Accept value-application/vnd.company.app-v1+json
	@GetMapping(value = "/person/header", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstPersonOfPersonProducestHeaderParam() {
	    return new PersonV1("John Doe");
	}

}
