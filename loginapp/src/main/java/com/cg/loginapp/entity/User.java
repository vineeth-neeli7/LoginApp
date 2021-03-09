package com.cg.loginapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.cg.loginapp.idclass.UserId;


@Entity
@Table(name="users")
@IdClass(UserId.class)
public class User{
	@Id
	@Column(name="Email_Id")
    private String emailId;

    @Id
    @Column(name="User_type")
    private String userType;
    
    @Column(name="First_name")
    private String firstName;
    
    @Column(name="Last_name")
    private String lastName;
    
    @Column(name="D.O.B")
    private String dob;
    
    @Column(name="Phone_no")
    private String phoneNo;
    
    @Column(name="Password")
    private String password;
    
   

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQue() {
		return securityQue;
	}

	public void setSecurityQue(String securityQue) {
		this.securityQue = securityQue;
	}

	public String getSecurityAns() {
		return securityAns;
	}

	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}

	@Column(name="Security_question")
    private String securityQue;
    
    @Column(name="Security_answer")
    private String securityAns ;
    
    
    
   
}

