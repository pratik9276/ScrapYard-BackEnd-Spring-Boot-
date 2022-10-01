
package com.app.springboot.scrapyard.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
	private String username;
	private String password;

}