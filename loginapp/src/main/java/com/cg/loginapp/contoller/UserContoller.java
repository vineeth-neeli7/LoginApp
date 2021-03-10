package com.cg.loginapp.contoller;

/**
 * author --> Sai Vineeth Neeli 
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.service.UserServices;


@RestController
public class UserContoller {
	
	 
	@Autowired
	private UserServices service; 
	
	
	/*
	 * User can SignUp 
	 */
	@PostMapping(value="/SignUp")
	public ResponseEntity<String> signUpPage(@RequestBody UserDTO userDto) throws SignUpExceptions
	{
		service.addSignUpDetails(userDto);
		return new ResponseEntity<>("Added Successfully",HttpStatus.ACCEPTED);
	}
	
	/*
	 * User Login page
	 */
	@PostMapping(value="/Login/{emailId}/{password}/{userType}")
	public ResponseEntity<String> loginPage(@PathVariable String emailId , @PathVariable String password ,
			@PathVariable String userType) throws SignUpExceptions,NullPointerException
	{
        String s = service.login(emailId,password,userType);
         return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	
	/*
	 * If User has Forgot the Password
	 */
	@PutMapping(value="/User/forgotPassword/{emailId}/{userType}/{securityAns}/{newPassword}/{reTypePassword}")
	public ResponseEntity<String> forgotPassWord(@PathVariable String emailId , @PathVariable String userType ,
			@PathVariable String securityAns ,@PathVariable String newPassword,@PathVariable String reTypePassword) throws SignUpExceptions,NullPointerException
	{
		String s = service.forgotPassword(emailId, userType, securityAns, newPassword, reTypePassword);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	
	
	 
}
