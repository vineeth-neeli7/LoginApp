package com.cg.loginapp.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.loginapp.contoller.SignUpExceptions;
import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.repository.LoginRepository;
import com.cg.loginapp.utils.LoginUtils;


@Service
public class UserServices {
	
	@Autowired
	LoginRepository repo;
	
	Pattern pEmail = Pattern.compile("^(.+)@(.+)$");
	Pattern pDate = Pattern.compile("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$");
	Pattern pString = Pattern.compile("[a-zA-Z]*");
	
	public String login(String emailId,String password,String userType) {
		User appuser=repo.findByCid(emailId,userType);

		 if(appuser.getPassword()==password)
		{
			return "Login successfully";
		}
		else
		{
			return "Invalid password or Email id or user type";
		}	
	}
	
	public String register(UserDTO userdto)
	{
		repo.saveAndFlush(LoginUtils.convertTouser(userdto));
		return "Registered successfully";
	}
	
	public static boolean passwordIsValid(String password) {

	    Pattern specialCharPatten = Pattern.compile("[~!@#$%^&*_-+=]");
	    Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
	    
	    boolean flag=true;

	    if (password.length() < 8 || !specialCharPatten.matcher(password).find() || 
	    	!UpperCasePatten.matcher(password).find() || !lowerCasePatten.matcher(password).find() || 
	    		!digitCasePatten.matcher(password).find()) {
	        flag=false;
	    }

	    return flag;

	}
	
	public void addSignUpDetails(UserDTO udto) throws SignUpExceptions
	{
		Matcher mEmail = pEmail.matcher(udto.getEmailId());
		Matcher mDate = pDate.matcher(udto.getDob());
		Matcher mFirstName = pString.matcher(udto.getFirstName()); 
		Matcher mLastName = pString.matcher(udto.getLastName());
		Matcher mSecurityAns = pString.matcher(udto.getSecurityAns());
		
		if(!mFirstName.matches() || udto.getFirstName().isBlank()) throw new SignUpExceptions("FirstName is not valid");
		
		else if(!mLastName.matches() ||udto.getLastName().isBlank()) throw new SignUpExceptions("LastName is not valid ");
		
		else if(udto.getPhoneNo().length() > 10 || udto.getPhoneNo().length() < 10) throw new SignUpExceptions("Phone Number is not valid");
		
		else if(!mEmail.matches() || udto.getEmailId().isBlank()) throw new SignUpExceptions("Email is invalid");
		
		else if(!mDate.matches() || udto.getDob().isBlank()) throw new SignUpExceptions("Invalid Date of Birth");
		
		else if(repo.findByCid(udto.getEmailId(),udto.getUserType())!=null) throw new SignUpExceptions("User is already present");
		
		else if(udto.getUserType().isBlank()) throw new SignUpExceptions("UserType should not be blank");
		
		else if(!mSecurityAns.matches() || udto.getSecurityAns().isBlank()) throw new SignUpExceptions("Securitu Answer is not valid");
		
		else if(passwordIsValid(udto.getPassword())) throw new SignUpExceptions("Password must contains atleast one UpperCase, LowerCase, SpecialCharacter, Numeric");
		
		else if(udto.getPassword()!=udto.getReTypePassword()) throw new SignUpExceptions("ReTypePassword should be same as Password");
		
		else {
		User u = LoginUtils.convertTouser(udto);
		
		repo.saveAndFlush(u);
		}
	}
	

}

