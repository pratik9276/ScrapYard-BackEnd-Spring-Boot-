package com.app.springboot.scrapyard.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.springboot.scrapyard.Repository.ScrapMaterialRepository;
import com.app.springboot.scrapyard.entity.ScrapMaterial;
import com.app.springboot.scrapyard.service.ScrapMaterialService;


@Service
public class ScrapMaterialServiceImpl implements ScrapMaterialService {

	@Autowired
	private ScrapMaterialRepository scrapMaterialRepository;
	
	
	  @Transactional
	  @Override
        public List<ScrapMaterial> findAll() 
        {
		return scrapMaterialRepository.findAll();
	    }
	  
	  @Transactional
	  @Override
		public List<ScrapMaterial> getAllScrapMaterial(int id)
		{
			return scrapMaterialRepository.getAllScrapMaterial(id);
		}
}
