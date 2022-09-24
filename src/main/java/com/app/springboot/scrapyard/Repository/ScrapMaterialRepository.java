package com.app.springboot.scrapyard.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.springboot.scrapyard.entity.ScrapMaterial;

@Repository
public interface ScrapMaterialRepository extends JpaRepository<ScrapMaterial, Integer> {

	
	
	
}
