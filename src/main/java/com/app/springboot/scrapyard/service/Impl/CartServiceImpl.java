package com.app.springboot.scrapyard.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.springboot.scrapyard.Repository.CartRepository;
import com.app.springboot.scrapyard.entity.Cart;
import com.app.springboot.scrapyard.entity.ScrapMaterial;
import com.app.springboot.scrapyard.service.CartService;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Transactional
	@Override
	public List<ScrapMaterial> getAllScrapMaterial(int id)
	{
		return cartRepository.getAllScrapMaterial(id);
	}
	
	@Transactional
	@Override
	public int deleteByScrapMaterialId(int id)
	{
		return cartRepository.deleteByScrapMaterialId(id);
	}
	
	@Transactional
	@Override
	public void addToCart(int id,int user_id,int scrap_material_id)
	{
		
		cartRepository.saveToCart(id, scrap_material_id, user_id);;
	}

	@Transactional
	@Override
	public int countOfParsentData()
	{
		return  (int) cartRepository.count();
	}

	@Override
	@Transactional
	public void deleteCartByUserId(int userId) {
		cartRepository.deleteCartByUserId(userId);
	}
	
}
