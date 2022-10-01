package com.app.springboot.scrapyard.payloads;

import java.util.Set;

import com.app.springboot.scrapyard.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDtoWithRoles {

	private int id;
	private String Fname;
	private String Lname;
	private String email;
	private String password;
	private String phoneNumber;
	private Role roles;
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
}
