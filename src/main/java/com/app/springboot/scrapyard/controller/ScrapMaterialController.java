package com.app.springboot.scrapyard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.scrapyard.entity.ScrapMaterial;
import com.app.springboot.scrapyard.service.ScrapMaterialService;

@RestController
@RequestMapping("/apiScrapMaterial")
@CrossOrigin("*")
public class ScrapMaterialController {

	@Autowired
	private ScrapMaterialService scrapMaterialService;
	
	@GetMapping("/getAllScrapMaterial")
	public List<ScrapMaterial> findAll() 
	{
		return scrapMaterialService.findAll();
	}
}
