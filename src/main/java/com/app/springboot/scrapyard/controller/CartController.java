package com.app.springboot.scrapyard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		System.out.println(cart.getUser());
		System.out.println(cart.toString());
		cartService.addToCart(0,cart.getUser(),cart.getScrapMaterial());
		return cart;
	}
	
	@GetMapping("/countOfData")
	public int countOfData()
	{
		return cartService.countOfParsentData();
	}
	
	@DeleteMapping("/deleteCartByUserId/{userId}")
	public ResponseEntity<String>deleteCartByUserId(@PathVariable Integer userId)
	{
		if(userId!=0)
		{
		 cartService.deleteCartByUserId(userId);
		 return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}