package com.freecharge.dc.entitymodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Users")
public class Users {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int ID;
@Column(unique = true)
private String email;

private String Status;

private String isEmailVerified;

private Date  createdOn;

private Date updatedOn;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getIsEmailVerified() {
	return isEmailVerified;
}
public void setIsEmailVerified(String isEmailVerified) {
	this.isEmailVerified = isEmailVerified;
}
public Date getCreatedOn() {
	return createdOn;
}
public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}
public Date getUpdatedOn() {
	return updatedOn;
}
public void setUpdatedOn(Date updatedOn) {
	this.updatedOn = updatedOn;
}



}

