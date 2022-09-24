package com.app.springboot.scrapyard.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springboot.scrapyard.entity.Customer;




@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	
	
}