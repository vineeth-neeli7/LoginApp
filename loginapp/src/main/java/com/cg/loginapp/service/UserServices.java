package com.cg.loginapp.service;

/**
 * author --> Sai Vineeth Neeli 
 */


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginapp.contoller.SignUpExceptions;
import com.cg.loginapp.entity.Admin;
import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.repository.AdminRepository;
import com.cg.loginapp.repository.LoginRepository;
import com.cg.loginapp.utils.LoginUtils;


@Service
public class UserServices {
	
	@Autowired
	LoginRepository repo;
	
	@Autowired
	AdminRepository adminRepo;
	
	Pattern pEmail = Pattern.compile("^(.+)@(.+)$");
	Pattern pString = Pattern.compile("[a-zA-Z]*");
	
	public String login(String emailId,String password,String userType) throws SignUpExceptions,NullPointerException{
		User appuser=repo.findByCid(emailId,userType);
       
		try {
		if(appuser.getPassword().equals(password))
		{
			return "Login successfully";
		}
		}
		catch(NullPointerException e)
		{
			throw new SignUpExceptions("Login Unsuccessful .. Invalid Password or Email or UserType ");	 
		}
		
		return "UnSuccessful";
	}
	
	public static boolean passwordIsValid(String password) {

	    Pattern specialCharPatten = Pattern.compile("[~!@#$%^&*_-]");
	    Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
	    
	    boolean flag=false;

	    if (password.length() >= 8 && specialCharPatten.matcher(password).find() && 
	    	UpperCasePatten.matcher(password).find() && lowerCasePatten.matcher(password).find() && 
	    		digitCasePatten.matcher(password).find()) {
	        flag=true;
	    }

	    return flag;

	}
	
	
	public void addSignUpDetails(UserDTO udto) throws SignUpExceptions
	{
		Matcher mEmail = pEmail.matcher(udto.getEmailId());
		Matcher mFirstName = pString.matcher(udto.getFirstName()); 
		Matcher mLastName = pString.matcher(udto.getLastName());
		Matcher mSecurityAns = pString.matcher(udto.getSecurityAns());
		
		if(!mFirstName.matches() || udto.getFirstName().isBlank()) throw new SignUpExceptions("FirstName is not valid");
		
		else if(!mLastName.matches() ||udto.getLastName().isBlank()) throw new SignUpExceptions("LastName is not valid ");
		
		else if(udto.getPhoneNo().length() != 10) throw new SignUpExceptions("Phone Number is not valid");
		
		else if(!mEmail.matches() || udto.getEmailId().isBlank()) throw new SignUpExceptions("Email is invalid");
		
		else if(repo.findByCid(udto.getEmailId(),udto.getUserType())!=null) throw new SignUpExceptions("User is already present");
		
		else if(udto.getUserType().isBlank()) throw new SignUpExceptions("UserType should not be blank");
		
		else if(!mSecurityAns.matches() || udto.getSecurityAns().isBlank()) throw new SignUpExceptions("Securitu Answer is not valid");
		
		else if(!passwordIsValid(udto.getPassword())) throw new SignUpExceptions("Password must contains atleast one UpperCase, LowerCase, SpecialCharacter, Numeric");
		
		else if(!udto.getPassword().equals(udto.getReTypePassword())) throw new SignUpExceptions("ReTypePassword should be same as Password");
		
		else {
		User u = LoginUtils.convertTouser(udto);
		
		repo.saveAndFlush(u);
		}
	}
	
	public String forgotPassword(String emailId , String userType , String securityAns , String newPassword , String reTypePassword) throws SignUpExceptions,NullPointerException
	{
		User u = repo.findByCid(emailId, userType);
		
		try { 
			if(!passwordIsValid(newPassword) || !u.getSecurityAns().equals(securityAns) || !newPassword.equals(reTypePassword))
			{
				throw new SignUpExceptions("Security Answer is Incorrect or Enter valid Password");
			}
			else
			{
				u.setPassword(newPassword);
				repo.saveAndFlush(u);
			}
			}
			catch(NullPointerException e)
			{
				throw new SignUpExceptions("User is Not found");
			}
		
		return "Changed Successfully";
	}
	
	 
	public List<User> getDetails()
	{
		return repo.findAll();
	}
	
	public String adminlogin(String emailId,String password) throws SignUpExceptions,NullPointerException{
		Admin appuser=adminRepo.findById(emailId).get();
       
		try {
		if(appuser.getAdminPassword().equals(password))
		{
			return "Login successfully";
		}
		}
		catch(NullPointerException e)
		{
			throw new SignUpExceptions("Login Unsuccessful .. Invalid Password or Email ");	 
		}
		
		return "UnSuccessful";
	}
	
}

