package com.app.springboot.scrapyard.service;

import com.app.springboot.scrapyard.payloads.UserDto;

public interface UserService {

    
    void deleteUser(Integer userId);
    
    UserDto createUser(UserDto user);
	
	UserDto registerNewCustomer(UserDto user);
	
	UserDto registerNewCollector(UserDto user);
	
	UserDto updateUser(UserDto user, Integer userId);
	
	UserDto getUserById(Integer userId);
}
