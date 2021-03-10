package com.cg.loginapp.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.service.UserServices;

// Sai Vineeth neeli 

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
	
	@PostMapping(value="/Login/{emailId}/{password}/{userType}")
	public ResponseEntity<String> loginPage(@PathVariable String emailId , @PathVariable String password , @PathVariable String userType) throws SignUpExceptions,NullPointerException
	{
        String s = service.login(emailId,password,userType);
         return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping(value="/User/forgotPassword/{emailId}/{userType}/{securityAns}/{newPassword}/{reTypePassword}")
	public ResponseEntity<String> forgotPassWord(@PathVariable String emailId , @PathVariable String userType , @PathVariable String securityAns ,@PathVariable String newPassword,@PathVariable String reTypePassword) throws SignUpExceptions,NullPointerException
	{
		String s = service.forgotPassword(emailId, userType, securityAns, newPassword, reTypePassword);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/details")
	public List<User> details()
	{
		return service.getDetails();
		//return new ResponseEntity("Tour details",HttpStatus.ACCEPTED);
	}
	
	
	//@PostMapping(value="/Login") done
	
	//@PutMapping(value="/User/forgotPassword") done
	
	//@PostMapping(value="/admin") done
	
	//@PostMapping(value="/admin/addUser")  done
	
	//@PutMapping(value="/admin/{email}/{usertype}") done
	
	//@GetMapping(value="/admin/{email}/{usertype}") done
	
	//@GetMapping(value="/admin/ListUsers") done
	
	//@DeleteMapping(value="/admin/{email}/{usertype}") done
	
	//repo for admin , entity admin .... 
}
