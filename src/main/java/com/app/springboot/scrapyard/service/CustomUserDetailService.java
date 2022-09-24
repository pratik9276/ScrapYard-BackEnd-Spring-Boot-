package com.app.springboot.scrapyard.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.springboot.scrapyard.Repository.UserRepository;
import com.app.springboot.scrapyard.entity.Customer;


@Service
public class CustomUserDetailService  implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer=this.userRepository.findByEmail(email);
		
		if(customer==null)
		{
			throw new UsernameNotFoundException("User not found !!");
		}
		else
		{
			return new CustomerUserDetails(customer);
		}
		
	}

	
	/*
	  By manual
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(username.equals("pratikjadhav9276@gmail.com"))
		{
			return new User("pratikjadhav9276@gmail.com","jadhav9276",new ArrayList<>());
		}
		else
		{
			throw new UsernameNotFoundException("User Not Found !!");
		}
	
	}
   */
	
	
	
	
}
