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
   
}

