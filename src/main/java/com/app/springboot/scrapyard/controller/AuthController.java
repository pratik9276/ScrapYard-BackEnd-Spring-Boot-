package com.app.springboot.scrapyard.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.scrapyard.entity.Customer;
import com.app.springboot.scrapyard.payloads.JwtAuthRequest;
import com.app.springboot.scrapyard.payloads.JwtAuthResponse;
import com.app.springboot.scrapyard.payloads.UserDto;
import com.app.springboot.scrapyard.security.JwtTokenHelper;
import com.app.springboot.scrapyard.service.CustomUserDetailService;
import com.app.springboot.scrapyard.service.CustomerUserDetails;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {

	

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody JwtAuthRequest request) throws Exception{
		this.authenticate(request.getUsername(), request.getPassword());
		System.out.println(request);
		UserDetails userDetails = this.customUserDetailService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response=new JwtAuthResponse(token);
		response.setToken(token);
		response.setUserDto(this.mapper.map((CustomerUserDetails)userDetails, UserDto.class));
		return  ResponseEntity.ok(response);
	}
	
	
	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {

			this.authenticationManager.authenticate(authenticationToken);

		} catch (DisabledException e) {
			throw new Exception("Invalid Detials !!");

		}

	}
}
