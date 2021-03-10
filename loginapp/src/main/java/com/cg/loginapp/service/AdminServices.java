package com.cg.loginapp.service;
/**
 * @author Neelambari k
 */

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginapp.contoller.SignUpExceptions;
import com.cg.loginapp.contoller.UserNotFoundException;
import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.repository.LoginRepository;


@Service
public class AdminServices {
	@Autowired
	LoginRepository repo;
	
	@Autowired
	UserServices userServices; 
	
	public  String addUser(UserDTO userdto) throws SignUpExceptions
	{
		userServices.addSignUpDetails(userdto);
		return "Added successfully";
	} 
	
	public String updateUser(String emailId,String userType,UserDTO userdto) throws UserNotFoundException
	{
		try {
      Optional<User> optional= Optional.of(repo.findByCid(emailId,userType));
		
		if(optional.isPresent()) {
			User user= optional.get();
			user.setDob(userdto.getDob());
            user.setPassword(userdto.getPassword());
   	        user.setFirstName(userdto.getFirstName());
		    user.setLastName(userdto.getLastName());
	        user.setPhoneNo(userdto.getPhoneNo());
 	        user.setSecurityAns(userdto.getSecurityAns());
			repo.saveAndFlush(user);
		}
		}
		catch(NullPointerException e){
			throw new UserNotFoundException("User not found for the given id,Update process failed");
		}
		
		return "Updated successsfully";
	}
	
	public List<User> listAllUsers(){
		 return repo.findAll();
	} 
	 
	public User listUser(String emailId,String userType) throws UserNotFoundException
	{
	  
	  User user = new User();
		try {
       Optional<User> optional= Optional.of(repo.findByCid(emailId,userType));
		
		if(optional.isPresent()) {
			user= optional.get();
		}
		}
		catch(NullPointerException e) {
			throw new UserNotFoundException("User not found for the given id,List process failed");
		}
		
		return user;
		
	}
	
	public String deleteUser(String emailId,String userType)throws UserNotFoundException {
		try {
		Optional<User> optional = Optional.of(repo.findByCid(emailId,userType));  
		User user;
		if(optional.isPresent()) {
			  user= optional.get();
			  repo.delete(user);
		} 
		 
		}
		catch(NullPointerException e){
			throw new UserNotFoundException("User not available ,Delete operation failed");
			
		}
			
		return "Deleted successfully"; 
	}
	
	
	
}
