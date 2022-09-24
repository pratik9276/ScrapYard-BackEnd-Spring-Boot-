package com.app.springboot.scrapyard.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.springboot.scrapyard.entity.Customer;


@Service
public class CustomerUserDetails implements UserDetails{

	@Autowired
	private Customer customer;
	
	
	public long getId() {
		return customer.getId();
	}

	public String getFname() {
		return customer.getFname();
	}


	public String getLname() {
		return customer.getLname();
	}


	public String getEmail() {
		return customer.getEmail();
	}

	

	public CustomerUserDetails(Customer customer) {
		this.customer=customer;
	}

	public  Customer getCustomer() {
		return customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>();
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
