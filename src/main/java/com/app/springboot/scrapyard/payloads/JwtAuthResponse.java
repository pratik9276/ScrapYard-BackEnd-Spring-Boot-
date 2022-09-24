package com.app.springboot.scrapyard.payloads;

import com.app.springboot.scrapyard.entity.Customer;

public class JwtAuthResponse {

	
	private String token;

	private UserDto userDto;
	
	

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public JwtAuthResponse() {
		
	}
	
	public JwtAuthResponse(String token) {
		this.token = token;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
	
}
