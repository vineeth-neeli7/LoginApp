package com.cg.loginapp.utils;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.UserDTO;

public class LoginUtils {
	public static User convertTouser(UserDTO userdto) {
	       User user=new User();
	       user.setDob(userdto.getDob());
	       user.setEmailId(userdto.getEmailId());
	       user.setUserType(userdto.getUserType());
	       user.setPassword(userdto.getPassword());
	       user.setFirstName(userdto.getFirstName());
	       user.setLastName(userdto.getLastName());
	       user.setPhoneNo(userdto.getPhoneNo());
	       user.setSecurityQue(userdto.getSecurityQue());
	       user.setSecurityAns(userdto.getSecurityAns());
	       return user;
	}
	
	public static UserDTO convertToUsetDTO(User user) {
	       UserDTO userdto=new UserDTO();
	       userdto.setDob(user.getDob());
	       userdto.setEmailId(user.getEmailId());
	       userdto.setUserType(user.getUserType());
	       userdto.setPassword(user.getPassword());
	       userdto.setFirstName(user.getFirstName());
	       userdto.setLastName(user.getLastName());
	       userdto.setPhoneNo(user.getPhoneNo());
	       userdto.setSecurityQue(user.getSecurityQue());
	       userdto.setSecurityAns(user.getSecurityAns());
	       return userdto;
	}
	
}