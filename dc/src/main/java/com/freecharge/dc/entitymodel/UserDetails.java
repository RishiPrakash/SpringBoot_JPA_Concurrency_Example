package com.freecharge.dc.entitymodel;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserDetailsID;
	private int UserId;
	private String Role;
	private String Aadhar;
	private String city;
	public int getUserDetailsID() {
		return UserDetailsID;
	}
	public void setUserDetailsID(int userDetailsID) {
		UserDetailsID = userDetailsID;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getAadhar() {
		return Aadhar;
	}
	public void setAadhar(String aadhar) {
		Aadhar = aadhar;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
