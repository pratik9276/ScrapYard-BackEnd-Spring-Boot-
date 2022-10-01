package com.app.springboot.scrapyard.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springboot.scrapyard.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	

}
