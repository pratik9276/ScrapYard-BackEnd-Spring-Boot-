package com.app.springboot.scrapyard.payloads;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class JwtAuthResponse {

	
	private String token;

	private UserDto userDto;
	//private UserDtoWithRoles userDtoWithRoles;
	
}
