package com.sapo.ex7_RestfullAPI_Spring.security;

import java.io.Serializable;

import lombok.Data;
@Data
public class LoginResponse implements Serializable {
    private String token;
    private String type = "Bearer";

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LoginResponse(String accessToken){
        this.token = accessToken;
    }
}
