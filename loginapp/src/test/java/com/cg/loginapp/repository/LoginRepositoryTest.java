package com.cg.loginapp.repository;
/**
 * @author Neelambari k
 */
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.entity.Admin;



@RunWith(SpringRunner.class)
@DataJpaTest

class LoginRepositoryTest {

	@Autowired
	public LoginRepository loginrepository;
	
	@Autowired
	public AdminRepository adminrepository;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	@Test
	 void testlogin() {
		User user=getuser();
        User saveInDb = testEntityManager.persist(user);
        User getFromInDb = loginrepository.findByCid(saveInDb.getEmailId(),saveInDb.getUserType());
        //Assert.assertEquals(5,5);
        assertThat(getFromInDb.getPassword()).isEqualTo(saveInDb.getPassword());
	}
	
	@Test
	 void testregister() {
		User user=getuser();
		User saveInDb = testEntityManager.persist(user);
		Assert.assertNotNull(saveInDb);
	}
	 @Test
	 void testAdminlogin()
	 {
		 Admin admin=getAdmin();
	        Admin saveInDb = testEntityManager.persist(admin);
	        Admin getFromInDb = adminrepository.findById(saveInDb.getAdminEmailId()).get();
	        assertThat(getFromInDb.getAdminPassword()).isEqualTo(saveInDb.getAdminPassword());
	 }
	 @Test
	 void testAddUser()
	 {
		 Admin admin=getAdmin();
	     Admin saveInDb = testEntityManager.persist(admin); 
	     Assert.assertNotNull(saveInDb);
	 }
	 @Test
	 void testUpdateUser()
	 {
		 User user=getuser();
	     User saveInDb = testEntityManager.persist(user);
	     User getFromInDb = loginrepository.findByCid(saveInDb.getEmailId(),saveInDb.getUserType());
	     
	     getFromInDb.setDob("22/04/2000");
	     getFromInDb.setPassword("@Mari123");
	     getFromInDb.setFirstName("Mari");
	     getFromInDb.setLastName("Evergreen");
	     getFromInDb.setPhoneNo("9852364875");
	     getFromInDb.setSecurityAns("Spain");
	     User updateInDb=testEntityManager.persist(getFromInDb);
	     assertThat(getFromInDb).isEqualTo(updateInDb);
	 }
	 @Test 
	 void testlistAllUser()
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
		    
		    testEntityManager.persist(user1);
		    testEntityManager.persist(user2);
		     
		     List<User> users = (List<User>) loginrepository.findAll();
		     Assert.assertEquals(2,users.size());
	 }
	 @Test
	 void testListUser()
	 {
		 User user=getuser();
	     User saveInDb = testEntityManager.persist(user);
	     User getFromInDb = loginrepository.findByCid(saveInDb.getEmailId(),saveInDb.getUserType());
	     assertThat(getFromInDb).isEqualTo(saveInDb);
	 }
	 @Test
	 void testDeleteUser()
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
		    
		    User user=testEntityManager.persist(user1);
		    testEntityManager.persist(user2);
		     
		    testEntityManager.remove(user);
		    
		     List<User> users = (List<User>) loginrepository.findAll();
		     Assert.assertEquals(1,users.size());
	 }
	 User getuser()
	{
		User user=new User();
		user.setEmailId("marithomas123@gmail.com");
	    user.setUserType("Admin");
	    user.setFirstName("Mari");
	    user.setFirstName("Thomas");
	    user.setDob("25.03.1992");
	    user.setPhoneNo("9582236485");
	    user.setPassword("wizard34");
	    user.setSecurityAns("India");
		return user;

}
	  Admin getAdmin()
	  {
		  Admin admin=new Admin();
		  admin.setAdminEmailId("adsmin254@gmail.com");
		  admin.setAdminPassword("admin");
		  return admin;
	  }
}