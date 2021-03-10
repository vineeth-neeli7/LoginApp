package com.cg.loginapp.repository;
/**
 * @author Neelambari k
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.loginapp.entity.User;
import com.cg.loginapp.idclass.UserId;


@Repository	
public interface LoginRepository extends JpaRepository<User,UserId>{

	@Query("select t from User t where t.emailId=:emailId and t.userType=:userType")
    User findByCid(String emailId,String userType);
	
}
