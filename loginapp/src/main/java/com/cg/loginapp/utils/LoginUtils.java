package com.cg.loginapp.utils;
<<<<<<< Updated upstream

=======
/**
 * @author Neelambari k
 */
import java.util.ArrayList;
import java.util.List;

import com.cg.loginapp.entity.Admin;
>>>>>>> Stashed changes
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
}