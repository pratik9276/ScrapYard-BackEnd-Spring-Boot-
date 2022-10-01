
package com.app.springboot.scrapyard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.scrapyard.entity.User;
import com.app.springboot.scrapyard.payloads.UserDto;
import com.app.springboot.scrapyard.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	
	
	@PostMapping("/customers")
	public ResponseEntity<UserDto> addUser(@RequestBody  UserDto userDto)
	{
		userDto.setId(0);
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public String deleteUser(@PathVariable  Integer userId)
	{
		userService.deleteUser(userId);
        return "Deleted EmployeeId : "+userId;
	}
	
	
	@PutMapping("/updatecustomer/{userId}")
	public ResponseEntity<UserDto> updateUser( @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}