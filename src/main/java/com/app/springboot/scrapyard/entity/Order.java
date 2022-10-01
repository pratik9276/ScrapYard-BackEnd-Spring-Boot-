package com.app.springboot.scrapyard.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="customer_order")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   
	@Column(name="id")
	private int id;
     
	@Column(name="name")
	private String scrapMaterialName;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity",precision = 5, scale = 2,columnDefinition = "double default 0")
	private double quantity;
	
	
	@Column(name="totalPrice",precision = 5, scale = 2,columnDefinition = "double default 0")
	private double totalPrice;
	
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name ="user_id")
	private User userId;
	
}
