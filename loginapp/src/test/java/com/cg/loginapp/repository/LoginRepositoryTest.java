package com.cg.loginapp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.loginapp.entity.User;



@RunWith(SpringRunner.class)
@DataJpaTest

class LoginRepositoryTest {

	@Autowired
	public LoginRepository loginrepository;
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
}