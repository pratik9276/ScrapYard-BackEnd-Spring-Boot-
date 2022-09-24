package com.app.springboot.scrapyard.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.app.springboot.scrapyard.entity.Customer;

@Repository
public interface UserRepository extends JpaRepository<Customer,Long>{
  
	public Customer findByEmail(String email);
}
