package com.app.springboot.scrapyard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.springboot.scrapyard.entity.ScrapMaterial;
import com.app.springboot.scrapyard.service.ScrapMaterialService;


@RestController
@RequestMapping("/apiScrapMaterial")

public class ScrapMaterialController {

	@Autowired
	private ScrapMaterialService scrapMaterialServiceImpl;
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@GetMapping("/getAllScrapMaterial")
	public List<ScrapMaterial> findAll() 
	{
		return scrapMaterialServiceImpl.findAll();
	}
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@GetMapping("/getAllScrapMaterial/{customerId}")
	public List<ScrapMaterial> getAllScrapMaterial(@PathVariable  Integer customerId)
	{
		return scrapMaterialServiceImpl.getAllScrapMaterial(customerId);
	}
}
