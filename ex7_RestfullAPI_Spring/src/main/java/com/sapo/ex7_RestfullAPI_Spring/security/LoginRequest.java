package com.sapo.ex7_RestfullAPI_Spring.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class LoginRequest implements Serializable{
	private String username;
    private String password;
    public LoginRequest() {
    	
    }
    public LoginRequest(String username,String password) {
    	this.username=username;
    	this.password=password;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
