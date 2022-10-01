package com.app.springboot.scrapyard.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.scrapyard.entity.User;
import com.app.springboot.scrapyard.exceptions.ApiException;
import com.app.springboot.scrapyard.payloads.JwtAuthRequest;
import com.app.springboot.scrapyard.payloads.JwtAuthResponse;
import com.app.springboot.scrapyard.payloads.UserDto;
import com.app.springboot.scrapyard.payloads.UserDtoWithRoles;
import com.app.springboot.scrapyard.security.JwtTokenHelper;
import com.app.springboot.scrapyard.service.UserService;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {

	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService ;

	@Autowired(required=true)
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		this.authenticate(request.getUsername(), request.getPassword());
		
		System.out.println(request);
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponse response=new JwtAuthResponse();
		response.setToken(token);
		//response.setUserDto(this.mapper.map((User) userDetails, UserDto.class));
		   response.setUserDto(this.mapper.map((User) userDetails, UserDto.class));
		//response.setUserDtoWithRoles(this.mapper.map((User) userDetails, UserDtoWithRoles.class));
		
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}
	
	
	private void authenticate(String username, String password) throws Exception {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);

		try {

			this.authenticationManager.authenticate(authenticationToken);

		} catch (BadCredentialsException e) {
			System.out.println("Invalid Detials !!");
			throw new ApiException("Invalid username or password !!");

		}

	}
	
	@PostMapping("/register/customer")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
		UserDto registeredUser = this.userService.registerNewCustomer(userDto);
		return new ResponseEntity<UserDto>(registeredUser, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/register/collector")
	public ResponseEntity<UserDto> registerCollector(@RequestBody UserDto userDto) {
		UserDto registeredUser = this.userService.registerNewCollector(userDto);
		return new ResponseEntity<UserDto>(registeredUser, HttpStatus.CREATED);
	}
}
