package com.app.springboot.scrapyard.payloads;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.springboot.scrapyard.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	
	private int id;
	private String Fname;
	private String Lname;
	private String email;
	private String password;
	private String phoneNumber;
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
