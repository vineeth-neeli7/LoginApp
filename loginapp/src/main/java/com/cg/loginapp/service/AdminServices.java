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
import com.cg.loginapp.utils.LoginUtils;


@Service
public class AdminServices {
	@Autowired
	LoginRepository repo;
	
	UserServices userServices=new UserServices();
	
	public  String addUser(UserDTO userdto) throws SignUpExceptions
	{
		userServices.addSignUpDetails(userdto);
		return "Added successfully";
	}
	public String updateUser(String emailId,String userType,UserDTO userdto) throws UserNotFoundException
	{
Optional<User> optional= Optional.of(repo.findByCid(emailId,userType));
		
		if(optional.isPresent()) {
			User user= optional.get();
			user.setDob(userdto.getDob());
            user.setPassword(userdto.getPassword());
   	        user.setFirstName(userdto.getFirstName());
		    user.setLastName(userdto.getLastName());
	        user.setPhoneNo(userdto.getPhoneNo());
 	        user.setSecurityAns(userdto.getSecurityAns());
			return "Updated successsfully";
		}
		else {
			throw new UserNotFoundException("User not found for the given id,Update process failed");
		}
	}
	public List<UserDTO> listAllUsers(){
		 List<User> list=repo.findAll();
		 return LoginUtils.convertToUserDtoList(list);
	}
	
	public UserDTO listUser(String emailId,String userType) throws UserNotFoundException
	{
       Optional<User> optional= Optional.of(repo.findByCid(emailId,userType));
		
		if(optional.isPresent()) {
			User user= optional.get();
			return LoginUtils.convertToUserDTO(user);
		}
		else {
			throw new UserNotFoundException("User not found for the given id,List process failed");
		}
	}
	
	public String deleteUser(String emailId,String userType)throws UserNotFoundException {
		Optional<User> optional = Optional.of(repo.findByCid(emailId,userType));  
		User user;
		if(optional.isPresent()) {
			  user= optional.get();
		}
		else{
			throw new UserNotFoundException("User not available ,Delete operation failed");
			
		}
			
		repo.delete(user);
		return "Deleted successfully";
	}
	
}
