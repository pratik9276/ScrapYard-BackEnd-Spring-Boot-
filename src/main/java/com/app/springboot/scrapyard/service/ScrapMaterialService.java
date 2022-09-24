package com.app.springboot.scrapyard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.springboot.scrapyard.Repository.ScrapMaterialRepository;
import com.app.springboot.scrapyard.entity.ScrapMaterial;


@Service
public class ScrapMaterialService {

	@Autowired
	private ScrapMaterialRepository scrapMaterialRepository;
	
	
	  @Transactional
        public List<ScrapMaterial> findAll() 
        {
		return scrapMaterialRepository.findAll();
	    }
}
