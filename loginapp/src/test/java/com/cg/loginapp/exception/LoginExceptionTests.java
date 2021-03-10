package com.cg.loginapp.exception;
/**
 * @author Neelambari k
 */


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;


import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.service.AdminServices;
import com.cg.loginapp.service.UserServices;

@RunWith(SpringRunner.class)

 class LoginExceptionTests {
	
	@Autowired 
	UserServices userService;
	
	@Autowired 
	AdminServices adminService;
	
	@Test
	void testAddSignUpDetails() 
	{
		UserDTO user=new UserDTO();
		user.setEmailId("tomthomas1");
	    user.setUserType("user");
	    user.setFirstName("Tom");
	    user.setFirstName("Thomas");
	    user.setDob("25.03.1992");
	    user.setPhoneNo("958223648521");
	    user.setPassword("wizard34");
	    user.setSecurityAns("India");
	    
	    Assertions.assertThrows(NullPointerException.class,() -> {userService.addSignUpDetails(user);} );
	    
	}
	@Test
	void testUpdateUser()
	{
		UserDTO user=new UserDTO();
		user.setEmailId("marithomas123@gmail.com");
	    user.setUserType("Admin");
	    user.setFirstName("Mari");
	    user.setFirstName("Thomas");
	    user.setDob("25.03.1992");
	    user.setPhoneNo("9582236485");
	    user.setPassword("wizard34");
	    user.setSecurityAns("India");
		
		Assertions.assertThrows(NullPointerException.class,() -> {adminService.updateUser("marina234@gmail.com","user",user);} );
	}
	
	@Test
	void testListUser()
	{
		Assertions.assertThrows(NullPointerException.class,() -> {adminService.listUser("thomas234@gmail.com","user");} );
	}
	
}
