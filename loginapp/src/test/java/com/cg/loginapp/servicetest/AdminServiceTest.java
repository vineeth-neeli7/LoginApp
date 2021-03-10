package com.cg.loginapp.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
//import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.loginapp.contoller.SignUpExceptions;
import com.cg.loginapp.contoller.UserNotFoundException;
import com.cg.loginapp.entity.User;
//import com.cg.loginapp.entity.Admin;
//import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.UserDTO;
import com.cg.loginapp.repository.AdminRepository;
import com.cg.loginapp.repository.LoginRepository;
import com.cg.loginapp.service.AdminServices;
import com.cg.loginapp.utils.LoginUtils;



@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {
	@Autowired
	private AdminServices adminService;
	
	@MockBean
	private AdminRepository adminRepo;
	@MockBean
	private LoginRepository repo;
	
	public static UserDTO userDetails() {
	UserDTO u = new UserDTO();
    
	u.setEmailId("hrejin231@gmail.com");
	u.setUserType("doc");
	u.setFirstName("sai");
	u.setLastName("vinnu");
	u.setPhoneNo("985623147");
	u.setPassword("Ksai#2");
	u.setReTypePassword("Ksai#2");
	u.setDob("12/05/1986");
	u.setSecurityQue("what is your birth place");
	u.setSecurityAns("madurai");
	 
	return u;
	}
	@Test
	void testAddUser() {
		UserDTO u1 = userDetails();
		String s1="Added successfully";
		try {
			
			User u2 = LoginUtils.convertTouser(u1);
			repo.saveAndFlush(u2);
			adminService.addUser(u1);
		 	}catch(SignUpExceptions e) {}
			
			try {
			assertEquals(s1,adminService.addUser(u1));
			}
			catch(SignUpExceptions | NullPointerException e) { }
		
		
	}
		
	   @Test
	   void testUpdateUser()  
	   {
		   UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");
			u1.setPassword("Va1234563#"); u1.setReTypePassword("Va1234563#");
			try {
			adminService.updateUser("vineeth@gmail.com","doc",u1);
			User u2 = LoginUtils.convertTouser(u1);
			repo.saveAndFlush(u2);
		 	}catch(UserNotFoundException e) {}
			
			try {
			assertEquals("Updated successsfully",adminService.updateUser("vineeth@gmail.com","doc",u1));
			}
			catch(UserNotFoundException | NullPointerException e) { }
	   }
		
	   @Test
	   void testListAllUsers()
	   {
		   User user1=new User();
			user1.setEmailId("marithomas123@gmail.com");
		    user1.setUserType("Admin");
		    user1.setFirstName("Mari");
		    user1.setFirstName("Thomas");
		    user1.setDob("25.03.1992");
		    user1.setPhoneNo("9582236485");
		    user1.setPassword("wizard34");
		    user1.setSecurityAns("India");
		    
		    User user2=new User();
			user2.setEmailId("marikevin123@gmail.com");
		    user2.setUserType("user");
		    user2.setFirstName("celine");
		    user2.setFirstName("Dan");
		    user2.setDob("25.03.1998");
		    user2.setPhoneNo("9582285485");
		    user2.setPassword("%thor234");
		    user2.setSecurityAns("Mexico");   
		    List<User> List = new ArrayList<>();
	        List.add(user1);
	        List.add(user2);

	        Mockito.when(repo.findAll()).thenReturn(List);
	        assertThat(adminService.listAllUsers()).isEqualTo(List);
	   }
        
	   @Test
	   void testDeleteUser() throws UserNotFoundException
	   {
		   UserDTO u1 = userDetails();
		   User u2 = LoginUtils.convertTouser(u1);
		   Mockito.when(repo.save(u2)).thenReturn(u2);
	        Mockito.when(repo.findByCid("hrejin231@gmail.com","doc")).thenReturn(u2);
	        adminService.deleteUser("hrejin231@gmail.com","doc");
	        Mockito.when(repo.findByCid("hrejin231@gmail.com","doc")).thenReturn(u2);
	        Assert.assertNotEquals(u2, new User());
	        Assert.assertEquals("Deleted successfully",adminService.deleteUser("hrejin231@gmail.com","doc"));
	   }
	   
	   @Test
	   void testExceptionDeleteUser()  
	   {
		   UserDTO u1 = userDetails();
		   User u2 = LoginUtils.convertTouser(u1);
		   Mockito.when(repo.save(u2)).thenReturn(u2);
			  String s1 = "User not available ,Delete operation failed";
			  try { adminService.deleteUser("hrejin231@gmail.com","user");}
			  catch(UserNotFoundException e){ assertEquals(s1,(e.getMessage()));}
	   }
	   @Test
	   void testExceptionUpdateUser()  
	   {
		   UserDTO u1 = userDetails();
		   User u2 = LoginUtils.convertTouser(u1);
		   Mockito.when(repo.save(u2)).thenReturn(u2);
			  String s1 = "User not found for the given id,Update process failed";
			  try { adminService.updateUser("vineeth@gmail.com","doc",u1);}
			  catch(UserNotFoundException e){ assertEquals(s1,(e.getMessage()));}
	   }
}

