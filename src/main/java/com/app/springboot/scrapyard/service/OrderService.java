package com.app.springboot.scrapyard.service;

import java.util.List;

import com.app.springboot.scrapyard.entity.Order;
import com.app.springboot.scrapyard.entity.User;

public interface OrderService {

	//void saveCustomerOrder(int price,double quantity,String name,double total_price,int user_id);
	
	void save(Order order);

	List<Integer> getAllUser();
	
	List<Order> getCustomerOrder(User user);

}
