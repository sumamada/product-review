package com.example.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String name;
	
	@Column(unique = true)
	private String username;
	private String password;
	private String address;
	private String mobileNo;
	
	
	
	public User() {
		super();
	}


	


	
	public User(int userId, String name, String username, String password, String address, String mobileNo) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.mobileNo = mobileNo;
	}
	

     @OneToMany(cascade = CascadeType.ALL,  mappedBy = "user")
     private List<Feedback> feedbacks;



	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", address=" + address + ", mobileNo=" + mobileNo + "]";
	}






	


	
	
	
}
