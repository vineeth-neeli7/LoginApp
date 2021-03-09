package com.cg.loginapp.idclass;

import java.io.Serializable;

public class UserId implements Serializable {
    private String emailId;
	private String userType;

    public UserId()
    {
    	
    }

    public UserId(String emailid, String usertype) {
        this.emailId = emailid;
        this.userType = usertype;
    }
   
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

}

