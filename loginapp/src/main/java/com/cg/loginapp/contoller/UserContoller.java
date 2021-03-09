package com.cg.loginapp.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.service.UserServices;



@RestController
public class UserContoller {
	
	@Autowired
	private UserServices service;
    
	
	@PostMapping(value="/SignUp")
	public ResponseEntity<String> signUpPage(@RequestBody UserDTO userDto) throws SignUpExceptions
	{
		service.addSignUpDetails(userDto);
		return new ResponseEntity<>("Added Successfully",HttpStatus.ACCEPTED);
	}
	
	//@PostMapping(value="/Login")
	
	
	//@PutMapping(value="/User/forgotPassword")
	
	//@PutMapping(value="/admin/forgotPassword")   Later
	
	//@PostMapping(value="/admin")
	
	//@PostMapping(value="/admin/addUser")  
	
	//@PutMapping(value="/admin/{email}/{usertype}") 
	
	//@GetMapping(value="/admin/{email}/{usertype}")
	
	//@GetMapping(value="/admin/ListUsers") 
	
	//@DeleteMapping(value="/admin/{email}/{usertype}")
	
	
}
