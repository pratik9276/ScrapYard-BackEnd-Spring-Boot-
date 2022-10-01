package com.app.springboot.scrapyard.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails{

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="fname")
	private String Fname;
	
	@Column(name="lname")
	private String Lname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
    @Column(name="phoneNumber")
    private String phoneNumber;
    
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
	private Set<Role> roles = new HashSet<>();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authories = this.roles.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authories;
		
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		 return this.email;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
//
//
//	public User()
//	{
//		
//	}
//	
//	
//	public String getFname() {
//		return Fname;
//	}
//	public void setFname(String fname) {
//		Fname = fname;
//	}
//	public String getLname() {
//		return Lname;
//	}
//	public void setLname(String lname) {
//		Lname = lname;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//	public int getId() {
//		return id;
//	}
//
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//
//	public User(int id, String fname, String lname, String email, String password) {
//		super();
//		this.id = id;
//		Fname = fname;
//		Lname = lname;
//		this.email = email;
//		this.password = password;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Customer [id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", password="
//				+ password + "]";
//	}
//	
	
	
	
}