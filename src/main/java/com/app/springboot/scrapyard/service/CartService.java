package com.app.springboot.scrapyard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.springboot.scrapyard.Repository.CartRepository;
import com.app.springboot.scrapyard.entity.Cart;
import com.app.springboot.scrapyard.entity.ScrapMaterial;


@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Transactional
	public List<ScrapMaterial> getAllScrapMaterial(int id)
	{
		return cartRepository.getAllScrapMaterial(id);
	}
	
	@Transactional
	public int deleteByScrapMaterialId(int id)
	{
		return cartRepository.deleteByScrapMaterialId(id);
	}
	
	@Transactional
	public void addToCart(int id,int customer_id,int scrap_material_id)
	{
		cartRepository.saveToCart(id, customer_id, scrap_material_id);;
	}

	@Transactional
	public int countOfParsentData()
	{
		return  (int) cartRepository.count();
	}
	
}
