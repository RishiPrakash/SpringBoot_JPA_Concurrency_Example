package com.freecharge.dc.model;



public class SignUpRequest {
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	private String email;
	private int UserId;
	private String Role;
	private String Aadhar;
	private String city;
}
