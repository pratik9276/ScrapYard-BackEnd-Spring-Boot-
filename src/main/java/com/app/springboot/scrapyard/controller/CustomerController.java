
package com.app.springboot.scrapyard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.scrapyard.entity.Customer;
import com.app.springboot.scrapyard.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService)
	{
		this.customerService=customerService;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer)
	{
		theCustomer.setId(0);
		customerService.save(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public String deleteCustomer(@PathVariable  Integer customerId)
	{
		customerService.deleteById(customerId);
        return "Deleted EmployeeId : "+customerId;
	}
	
	@PutMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer theCustomer)
	{
		customerService.save(theCustomer);
		return theCustomer;
	}
}