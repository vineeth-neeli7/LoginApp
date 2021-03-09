package com.cg.loginapp.model;

import org.springframework.stereotype.Component;

@Component
public class Admin {
	
    private String adminEmailId;
    private String adminPassword="admin";
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
    
    

}
