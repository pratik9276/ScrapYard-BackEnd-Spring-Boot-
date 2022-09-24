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
@Table(name="customer")
public class Customer{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="Fname")
	private String Fname;
	
	@Column(name="Lname")
	private String Lname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public Customer()
	{
		
	}
	
	
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Customer(int id, String fname, String lname, String email, String password) {
		super();
		this.id = id;
		Fname = fname;
		Lname = lname;
		this.email = email;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	
	
}