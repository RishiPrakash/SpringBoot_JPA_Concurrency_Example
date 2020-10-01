package com.freecharge.dc.model;

public class VerifyRequest {
 private String email;
 private int OTPValue;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getOTPValue() {
	return OTPValue;
}
public void setOTPValue(int oTPValue) {
	OTPValue = oTPValue;
}
}
