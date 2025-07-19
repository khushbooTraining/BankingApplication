package com.banking.banking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_app.entity.AuthRequest;

@RestController
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/authRequest")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		
		authenticationManager.authenticate(null);
		return "jwt token";
		
	}

}
