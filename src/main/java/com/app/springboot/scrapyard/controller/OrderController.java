package com.app.springboot.scrapyard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.springboot.scrapyard.entity.Order;
import com.app.springboot.scrapyard.entity.User;
import com.app.springboot.scrapyard.payloads.OrderDto;
import com.app.springboot.scrapyard.payloads.UserDto;
import com.app.springboot.scrapyard.service.OrderService;
import com.app.springboot.scrapyard.service.UserService;

@RestController
@RequestMapping("/apiOrder")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@PostMapping("/saveCustomerOrder")
	public ResponseEntity<String> saveCustomerOrder(@RequestBody   List<OrderDto> orderDto)
	{
		
		System.out.println("in body");
		
		for (OrderDto orderDto1 : orderDto) {
			if(orderDto1.getUserId()!=0)
			{
			Order order=new Order();
			System.out.println(orderDto);
			UserDto userDto=userService.getUserById(orderDto1.getUserId());
			User user = this.modelMapper.map(userDto, User.class);
			order.setId(0);
		    order.setPrice(orderDto1.getPrice());
			order.setQuantity(orderDto1.getQuantity());
			order.setScrapMaterialName(orderDto1.getScrapMaterialName());
			order.setTotalPrice(orderDto1.getTotalPrice());
			order.setUserId(user);
			System.out.println(order);
			orderService.save(order);
			return new ResponseEntity<>(HttpStatus.OK);
			}
			else
				break;
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		
	}

	
	// get all customer who ordered scrap
	
	@PreAuthorize("hasRole('COLLECTOR')")
	@GetMapping("/getAllCustomer")
	public List<UserDto> getAllUser()
	{
		List<UserDto> users=new ArrayList<UserDto>();
		
		List<Integer>userList = orderService.getAllUser();
		
		for (Integer userId :userList) {
		UserDto userDto=userService.getUserById(userId);
		//User user = this.modelMapper.map(userDto, User.class);
		users.add(userDto);
		}
		return users;
	}
	
	// get all order of particular user
	
	@PreAuthorize("hasRole('COLLECTOR')")
	@GetMapping("/getCustomerOrder/{userID}")
	public List<OrderDto> getCustomerOrder(@PathVariable Integer userID )
	{
		UserDto userDto=userService.getUserById(userID);
		List<OrderDto> orderDto=new ArrayList<OrderDto>();
		
		User user = this.modelMapper.map(userDto, User.class);
		List<Order> order=orderService.getCustomerOrder(user);
		if(!order.isEmpty())
		{
			for (Order order2 : order) {
				OrderDto ud=new OrderDto();
				ud.setId(order2.getId());
				ud.setPrice(order2.getPrice());
				ud.setQuantity(order2.getQuantity());
				ud.setScrapMaterialName(order2.getScrapMaterialName());
				ud.setTotalPrice(order2.getTotalPrice());
				orderDto.add(ud);
			}
		   
			return orderDto;
		}
		return null;
	}
}
