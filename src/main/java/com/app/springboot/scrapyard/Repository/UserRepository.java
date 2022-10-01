package com.app.springboot.scrapyard.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.springboot.scrapyard.entity.User;


public interface UserRepository extends JpaRepository<User,Integer>{
  
	Optional<User> findByEmail(String email);
}
