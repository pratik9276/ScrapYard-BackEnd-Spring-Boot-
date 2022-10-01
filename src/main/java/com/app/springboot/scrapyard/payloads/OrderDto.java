package com.app.springboot.scrapyard.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class OrderDto {

	private int id;
	private int price;
	private double quantity;
	private String scrapMaterialName;
	private double totalPrice;
	private int userId;
	
//	"price":0, 
//    "quantity":5.0,
//    "scrapMaterialName": "pratik",
//    "totalPrice":10.0,
//    "userId":6
}
