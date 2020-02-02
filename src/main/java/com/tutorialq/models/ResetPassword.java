package com.tutorialq.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResetPassword implements Serializable {

    private String emailId;
    private String password;
    private String password2;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
    
    

}
