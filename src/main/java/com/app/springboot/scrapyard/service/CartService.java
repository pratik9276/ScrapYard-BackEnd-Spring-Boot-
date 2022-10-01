package com.app.springboot.scrapyard.service;

import java.util.List;

import com.app.springboot.scrapyard.entity.ScrapMaterial;

public interface CartService {

	public List<ScrapMaterial> getAllScrapMaterial(int id);
	
	public void addToCart(int id,int user_id,int scrap_material_id);
	
	public int deleteByScrapMaterialId(int id);
	
	public int countOfParsentData();
	
	void deleteCartByUserId(int userId);
}
