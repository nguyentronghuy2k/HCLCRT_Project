package com.shopping.model;

public class User {
	private Long id;
	private String username;
	private String password;
	private String fullName;
	private String email;
	private String phoneNumber;
	private String address;
	private Integer type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public User() {
		
	}
	public User(Long id, String username, String password, String fullName, String email, String phoneNumber,
			String address, Integer type) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.type = type;
	}
	
	
	
}
