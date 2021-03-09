package com.cg.loginapp.model;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
	    private String emailId;
	    private String userType;
	    private String firstName;
	    private String lastName;
	    private String dob;
	    private String phoneNo;
	    private String password;
		private String reTypePassword;
	    private String securityQue="What is your birth place?";
	    private String securityAns;
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
		public String getReTypePassword() {
			return reTypePassword;
		}
		public void setReTypePassword(String reTypePassword) {
			this.reTypePassword = reTypePassword;
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
	    
	    

}

