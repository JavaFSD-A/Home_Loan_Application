package com.yourcastle.homeloan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourcastle.homeloan.entity.Login;
import com.yourcastle.homeloan.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService service;
	
	@PostMapping(value = "/{role}",consumes = "application/json")
	public String authenticateUser(@RequestBody Login login, @PathVariable("role") String role) {
		if(service.authenticationUser(login, role) == null)
			return "Invalid User or Password of " + role;
		else {
			return "Login Successful...for user : " + login.getRole() + " with phone no " + login.getPhone_no();
		}
		
	}
}
