package com.app.springboot.scrapyard.service.Impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.springboot.scrapyard.Repository.OrderRepository;
import com.app.springboot.scrapyard.entity.Order;
import com.app.springboot.scrapyard.entity.User;
import com.app.springboot.scrapyard.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	@Transactional
	public void save(Order order) {
		orderRepository.save(order);
		
	}
	
	@Override
	@Transactional
	public List<Integer> getAllUser()
	{
		return orderRepository.getAllUser();
	}

	@Override
	@Transactional
	public List<Order> getCustomerOrder(User user)
	{
	 return orderRepository.getCustomerOrder(user);
	}
	

}
