package com.app.springboot.scrapyard.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.springboot.scrapyard.Repository.UserRepository;
import com.app.springboot.scrapyard.entity.User;
import com.app.springboot.scrapyard.exceptions.ResourceNotFoundException;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User ", " email : " + username, 0));
			System.out.println("roles :"+user.getRoles());	
		return user;
	}

}
