package com.app.springboot.scrapyard.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name="cart")
@NoArgsConstructor
@Getter
@Setter
public class Cart {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private int user;
	
	
	@ManyToOne(targetEntity=ScrapMaterial.class,cascade=CascadeType.ALL)
	@JoinColumn(name = "scrap_material_id")
	private int scrapMaterial;

    public Cart(Cart cart)
    {
    	this.id=cart.id;
    	this.user=cart.user;
    	this.scrapMaterial=cart.scrapMaterial;
    }
	
}
