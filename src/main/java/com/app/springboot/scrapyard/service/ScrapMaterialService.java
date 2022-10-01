package com.app.springboot.scrapyard.service;

import java.util.List;

import com.app.springboot.scrapyard.entity.ScrapMaterial;

public interface ScrapMaterialService {

	public List<ScrapMaterial> findAll() ;
	
	public List<ScrapMaterial> getAllScrapMaterial(int id);
}
