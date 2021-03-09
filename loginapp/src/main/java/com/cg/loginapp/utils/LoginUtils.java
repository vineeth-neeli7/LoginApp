package com.cg.loginapp.utils;

import java.util.ArrayList;
import java.util.List;

import com.cg.loginapp.entity.Admin;
import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.AdminDTO;
import com.cg.loginapp.model.UserDTO;


public class LoginUtils {
	private LoginUtils() {
	    throw new IllegalStateException("Utility class");
	  }
	public static User convertToUser(UserDTO userdto) {
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
	
	public static List<UserDTO> convertToUserDtoList(List<User> list){
		List<UserDTO> dtolist = new ArrayList<>();
		for(User user : list) 
			dtolist.add(convertToUserDTO(user));
		return dtolist;
	}
	public static UserDTO convertToUserDTO(User user) {
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
	
	
	public static AdminDTO convertToAdminDTO(User user)
	{
		AdminDTO admindto=new AdminDTO();
		admindto.setAdminEmailId(user.getEmailId());
		admindto.setAdminPassword(user.getPassword());
		return admindto;
	}
	
	public static Admin convertToAdmin(User user)
	{
		Admin admin=new Admin();
		AdminDTO admindto=convertToAdminDTO(user);
		admin.setAdminEmailId(admindto.getAdminEmailId());
		admin.setAdminPassword(admindto.getAdminPassword());
		return admin;
	}
}