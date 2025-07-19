package com.khushboo.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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

import jakarta.validation.Valid;

@RestController
public class UserResource {
	   
	//@Autowired
	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService=userDaoService;
	}
	//
	@GetMapping(path="/user")
	public List<User> getAllUsers(){
		return userDaoService.findAll();
		
	}
	
/*	@GetMapping(path="/user")
	public EntityModel<List<User>> getAllUsers(){
		List<User> ls=userDaoService.findAll();
		EntityModel entityModel=EntityModel.of(ls);
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getUser(0));
		entityModel.add(link.withRel("one=user"));
		return entityModel;
		
	}*///use collection model here
	
	
	//http://localhost:8080/user/   
	//EntityModel     //WebMvcLinkBuilder   hateoas
	@GetMapping(path="/user/{id}")
	public EntityModel<User> getUser(@PathVariable int id){
	User uss= userDaoService.findOne(id);
		
		if(uss==null) {
			throw new UserNotFoundException("Resource not found for the id "+id);
		}
			EntityModel<User> entityModel=EntityModel.of(uss);		
			WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getAllUsers());
			entityModel.add(link.withRel("all-users"));
			return entityModel;
		
	}
	
	
	/*@PostMapping(path="/users")
	public void createUser(@RequestBody User users) {
		userDaoService.saveUser(users);
	}*/
	
	
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User users) {
		User u=userDaoService.saveUser(users);
		//  /users/{id}  user.getID()  uri
 		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
 			.path("/{id}")
 				.buildAndExpand(u.getId())
 				.toUri();
       return ResponseEntity.created(location).build();
     }
	
	@DeleteMapping(path="/user/{id}")
	public void deleteById(@PathVariable int id) {
		userDaoService.delete(id);
		
	}
}
