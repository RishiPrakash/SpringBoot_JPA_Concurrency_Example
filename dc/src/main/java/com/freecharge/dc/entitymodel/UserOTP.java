package com.freecharge.dc.entitymodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserOTP")
public class UserOTP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OTPID;
	private int UserId;
	private int OTP;
	@Column(unique = true)
	private String email;
	private Date GeneratedOn;
	private Date VerifiedOn;
	public int getOTPID() {
		return OTPID;
	}
	public void setOTPID(int oTPID) {
		OTPID = oTPID;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getOTP() {
		return OTP;
	}
	public void setOTP(int oTP) {
		OTP = oTP;
	}
	public Date getGeneratedOn() {
		return GeneratedOn;
	}
	public void setGeneratedOn(Date generatedOn) {
		GeneratedOn = generatedOn;
	}
	public Date getVerifiedOn() {
		return VerifiedOn;
	}
	public void setVerifiedOn(Date verifiedOn) {
		VerifiedOn = verifiedOn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
