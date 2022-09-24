
package com.app.springboot.scrapyard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.springboot.scrapyard.Repository.CustomerRepository;
import com.app.springboot.scrapyard.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
		super();
		this.customerRepository=customerRepository;
	}
	
	@Override
	@Transactional
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}
	
}