package com.mobapp.demo.entity;

import java.io.Serializable;

public class Login implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
}
