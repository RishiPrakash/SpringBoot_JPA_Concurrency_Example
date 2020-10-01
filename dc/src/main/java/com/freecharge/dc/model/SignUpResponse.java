package com.freecharge.dc.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SignUpResponse {
	private int OTP;
	private Date createdAt;
	public int getOTP() {
		return OTP;
	}
	public void setOTP(int oTP) {
		OTP = oTP;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
