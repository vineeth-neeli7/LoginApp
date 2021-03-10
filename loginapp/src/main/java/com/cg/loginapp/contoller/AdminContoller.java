package com.cg.loginapp.contoller;

/**
 * author --> Sai Vineeth Neeli 
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.service.AdminServices;

@RestController
public class AdminContoller {
	
	@Autowired
	private AdminServices adminService;
    
	/*
	 *  Admin can add the User
	 */
	@PostMapping(value="/admin/addUser") 
	public ResponseEntity<String> adminAddUser(@RequestBody UserDTO userdto) throws SignUpExceptions
	{
		String s = adminService.addUser(userdto);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
		
	/*
	 *  Admin can update the User Details by EmailId and UserType
	 */
	@PutMapping(value="/admin/updateUser/{emailId}/{userType}") 
	public ResponseEntity<String> adminUpdateUser(@PathVariable String emailId ,@PathVariable String userType ,@RequestBody UserDTO userdto) throws UserNotFoundException
	{ 
		String s = adminService.updateUser(emailId, userType, userdto);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
	 
	/*
	 *  Admin can view all the Users
	 */
	@GetMapping(value="/admin/getAllUser") 
	public List<User> adminGetAllUser()
	{
		return adminService.listAllUsers();
	}
	
	/*
	 *  Admin can view all the User Details by EmailId and UserType
	 */
	@GetMapping(value="/admin/getById/{emailId}/{userType}")
	public User adminGetUserById(@PathVariable String emailId , @PathVariable String userType) throws UserNotFoundException
	{
		return adminService.listUser(emailId,userType);
	}
	
	/*
	 *  Admin can Delete the User
	 */
	@DeleteMapping(value="/admin/deleteById/{emailId}/{userType}") 
	public String adminDeleteUserById(@PathVariable String emailId , @PathVariable String userType) throws UserNotFoundException
	{
		System.out.println("deletemapping");
		return adminService.deleteUser(emailId, userType);
	}
	

}
