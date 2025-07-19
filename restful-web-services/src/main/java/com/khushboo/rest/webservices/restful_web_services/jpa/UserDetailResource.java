package com.khushboo.rest.webservices.restful_web_services.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.khushboo.rest.webservices.restful_web_services.user.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserDetailResource {
	private UserDetailRepository userDetailRepository;
	
	public UserDetailResource(UserDetailRepository userDetailRepository) {
		super();
		this.userDetailRepository = userDetailRepository;
	}
   @Autowired
	private SubjectDetailRepository subjectDetailRepository;
	
	@GetMapping("/userDetail/jpa/{id}")
	public  EntityModel<UserDetail> getUserDetail(@PathVariable int id) {
		Optional<UserDetail> u =userDetailRepository.findById(id);
		
		if(u.isEmpty()) {
			throw new UserNotFoundException("id "+id);
		}
		EntityModel<UserDetail> entityModel= EntityModel.of(u.get());
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUserDetail());
		entityModel.add(link.withRel("all-usersDetail"));
	   
		return entityModel;
	} 
	@GetMapping("/userDetail/jpa")
	public List<UserDetail> getAllUserDetail() {
		List<UserDetail> u =userDetailRepository.findAll();
		return u;
	}
	
	
	@DeleteMapping("/userDetail/jpa/delete/{id}")
	public void deleteUserDetail(@PathVariable int id) {

		 userDetailRepository.deleteById(id);	
	}
	
	//create a user
	@PostMapping("/userDetail/jpa/post")
	public ResponseEntity<UserDetail> createUser(@Valid @RequestBody UserDetail users) {
		UserDetail u=userDetailRepository.save(users);
		//  /users/{id}  user.getID()  uri
 		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
 			.path("/{id}")
 				.buildAndExpand(u.getId())
 				.toUri();
       return ResponseEntity.created(location).build();
     }

	@GetMapping("/userDetail/jpa/subject/{id}")
	public List<Subject> getSubjectDetail(@PathVariable int id) {
		Optional<UserDetail> u =userDetailRepository.findById(id);
		//return null;
		
		
		return u.get().getSubject();
	}
	
	@PostMapping("/userDetail/jpa/post/{id}")
	public ResponseEntity<Subject> createSubjectAUser(@Valid @RequestBody Subject sub,@PathVariable int id ) {
		Optional<UserDetail> u=userDetailRepository.findById(id);
		//  /users/{id}  user.getID()  uri
		if(u.isEmpty()) {
			throw new UserNotFoundException("id not found"+id);
		}
		sub.setUserDetail(u.get());
		subjectDetailRepository.save(sub);
 		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
 			.path("/{id}")
 				.buildAndExpand(sub.getId())
 				.toUri();
       return ResponseEntity.created(location).build();
     }
	
	@GetMapping("/userDetail/jpa/us/{id}")
	public List<UserDetail> getAllUserAndSubjectdetail(@PathVariable int id) {
		
		Optional<UserDetail> userDetail=userDetailRepository.findById(id);
		if(userDetail.isEmpty()) {
			throw new UserNotFoundException("id not found:"+id);
		
		}
	//	List<Integer,String> a=new ArrayList<Integer,String>();
		
		return null;//userDetail.get().getSubject();
		
	}
}


