package com.app.springboot.scrapyard.service;

import com.app.springboot.scrapyard.entity.Customer;

public interface CustomerService {

    public void save(Customer theCustomer);
	
	public void deleteById(int theId);
}
