package com.app.springboot.scrapyard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.scrapyard.entity.Cart;
import com.app.springboot.scrapyard.entity.ScrapMaterial;
import com.app.springboot.scrapyard.entity.ScrapMaterialData;
import com.app.springboot.scrapyard.service.CartService;

@RestController
@RequestMapping("/apiCart")
@CrossOrigin("*")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/getAllScrapMaterial/{customerId}")
	public List<ScrapMaterial> getAllScrapMaterial(@PathVariable  Integer customerId)
	{
		//List<ScrapMaterial> data=cartService.getAllScrapMaterial(customerId)	
		return cartService.getAllScrapMaterial(customerId);
	}
	
	@DeleteMapping("/deleteScrapMaterialFormCart/{scrapMaterialId}")
	public int deleteByScrapMaterialId(@PathVariable Integer scrapMaterialId)
	{
		 
        return cartService.deleteByScrapMaterialId(scrapMaterialId);
        //return cartService.getAllScrapMaterial(scrapMaterialId);
	}
	
	@PostMapping("/addToCart")
	public Cart addToCart(@RequestBody Cart cart)
	{
		System.out.println(cart.getId());
		System.out.println(cart.getCustomer());
		System.out.println(cart.toString());
		cartService.addToCart(0,cart.getCustomer(),cart.getScrapMaterial());
		return cart;
	}
	
	@GetMapping("/countOfData")
	public int countOfData()
	{
		return cartService.countOfParsentData();
	}
	
}