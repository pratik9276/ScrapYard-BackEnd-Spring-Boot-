package com.app.springboot.scrapyard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="scrapMaterial")
public class ScrapMaterial {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ScrapMaterial() {}
	public ScrapMaterial(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "ScrapMaterial [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

	

	
	
}
