package com.app.springboot.scrapyard.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="cart")
public class Cart {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Customer.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private int customer;
	
	
	@ManyToOne(targetEntity=ScrapMaterial.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "scrap_material_id")
	private int scrapMaterial;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCustomer() {
		return customer;
	}


	public void setCustomer(int customer) {
		this.customer = customer;
	}


	public int getScrapMaterial() {
		return scrapMaterial;
	}


	public void setScrapMaterial(int scrapMaterial) {
		this.scrapMaterial = scrapMaterial;
	}


	public Cart(int id, int customer, int scrapMaterial) {
		super();
		this.id = id;
		this.customer = customer;
		this.scrapMaterial = scrapMaterial;
	}

	
	public Cart() {}

	public Cart(Cart cart)
	{
		this.id=cart.id;
		this.customer=cart.customer;
		this.scrapMaterial=cart.scrapMaterial;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", customer=" + customer + ", scrapMaterial=" + scrapMaterial + "]";
	}
	
	
	
}
