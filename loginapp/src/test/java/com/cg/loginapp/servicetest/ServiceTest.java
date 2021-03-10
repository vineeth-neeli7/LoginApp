package com.cg.loginapp.servicetest;

/**
 * author --> Sai Vineeth Neeli 
 */


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.loginapp.repository.LoginRepository;
import com.cg.loginapp.service.UserServices;
import com.cg.loginapp.utils.LoginUtils;
import com.cg.loginapp.contoller.SignUpExceptions;
import com.cg.loginapp.entity.User;
import com.cg.loginapp.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceTest {

		@Autowired
		private UserServices service;
		
		@MockBean
		private LoginRepository repo;
		
		
		public static UserDTO userDetails() {
		UserDTO u = new UserDTO();
	    
		u.setEmailId("fghn7#dfgbn.in");
		u.setUserType("doc");
		u.setFirstName("sai7");
		u.setLastName("vinnu9");
		u.setPhoneNo("985623147");
		u.setPassword("sai#2");
		u.setReTypePassword("vin%");
		u.setDob("12");
		u.setSecurityQue("how you");
		u.setSecurityAns("hey");
		 
		return u;
		}
		
		@Test
		public void addSignUpTestFirstName() {
		UserDTO u1 = userDetails();
	    String s1 = "FirstName is not valid";
		try { service.addSignUpDetails(u1);}
		catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage()));}
	   }
		
        @Test
		public void addSignUpTestFirstNameBlank()
		{ UserDTO u1 = userDetails(); 
		  u1.setFirstName("");
		  String s1 = "FirstName is not valid";
		  try { service.addSignUpDetails(u1);}
		  catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage()));}
			
		} 
		
		@Test
		public void addSignUpTestLastName(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai");
			String s1 = "LastName is not valid ";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestLastNameBlank(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai");
			u1.setLastName("");
			String s1 = "LastName is not valid ";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestPhn(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu");
			String s1 = "Phone Number is not valid";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestEmailIdBlank(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("");
			String s1 = "Email is invalid";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestEmailId(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301");
			String s1 = "Email is invalid";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestUserFound() {
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");
			User u2 = LoginUtils.convertTouser(u1);
			repo.saveAndFlush(u2);
			String s1 = "User is already present";
			try { 
			   if(repo.findByCid(u1.getEmailId(),u1.getUserType())!=null) throw new SignUpExceptions("User is already present");
			 }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestUserType(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");
			u1.setUserType("");
			String s1 = "UserType should not be blank";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestPassword(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");u1.setUserType("doctor");
			String s1 = "Password must contains atleast one UpperCase, LowerCase, SpecialCharacter, Numeric";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestRePassword(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");u1.setUserType("doctor");
			u1.setPassword("Vin#123456");
			String s1 = "ReTypePassword should be same as Password";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpTestSecurityAns(){
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");u1.setUserType("doctor");
			u1.setSecurityAns("Vin6");
			String s1 = "Securitu Answer is not valid";
			try { service.addSignUpDetails(u1); }
			catch(SignUpExceptions e){ assertTrue(s1.equals(e.getMessage())); }
		}
		
		@Test
		public void addSignUpDone() {
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");
			u1.setPassword("Va1234563#"); u1.setReTypePassword("Va1234563#");
			try {
			service.addSignUpDetails(u1);
			User u2 = LoginUtils.convertTouser(u1);
			User u3 = repo.saveAndFlush(u2);
			if(u2.equals(u3)) { assertTrue(true);}
			}catch(SignUpExceptions e) {}
					
		}
		
		@Test
		public void loginTest()
		{
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");
			u1.setPassword("Va1234563#"); u1.setReTypePassword("Va1234563#");
			try {
			service.addSignUpDetails(u1);
			User u2 = LoginUtils.convertTouser(u1);
			repo.saveAndFlush(u2);
		 	}catch(SignUpExceptions e) {}
			
			try {
			assertEquals("Login successfully",service.login("vineeth@gmail.com","Va1234563#","doc"));
			}
			catch(SignUpExceptions | NullPointerException e) { }
		}
			
		
		@Test
		public void forgotPasswordTest()
		{
			UserDTO u1 = userDetails();
			u1.setFirstName("sai"); u1.setLastName("vinnu"); u1.setPhoneNo("9857426301"); u1.setEmailId("vineeth@gmail.com");
			u1.setPassword("Va1234563#"); u1.setReTypePassword("Va1234563#");
			try {
			service.addSignUpDetails(u1);
			User u2 = LoginUtils.convertTouser(u1);
			repo.saveAndFlush(u2);
		 	}catch(SignUpExceptions e) {}
			
			try {
				assertEquals("Changed Successfully",service.forgotPassword("vineeth@gmail.com","doc","hey","Va1234562#","Va1234562#"));
				}
				catch(SignUpExceptions | NullPointerException e) { }
		}
}
