package com.freecharge.dc.repository;


import java.util.Date;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freecharge.dc.entitymodel.Users;
import com.freecharge.dc.entitymodel.UserDetails;
import com.freecharge.dc.entitymodel.UserOTP;
import com.freecharge.dc.model.SignUpRequest;
import com.freecharge.dc.util.SystemUtil;



@Repository
public class SignUpRepository{
	@Autowired
	private EntityManager entityManager;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public UserOTP save(SignUpRequest signUpRequest) {
		
		Users user = this.saveUser(signUpRequest);
		this.saveUserDetails(signUpRequest,user.getID());
		UserOTP userOTp = this.saveOTPDetails(signUpRequest,user.getID());
		return userOTp;
	}
	
	
	public Users saveUser(SignUpRequest signUpRequest) {
		
		Users user = new Users();
		user.setEmail(signUpRequest.getEmail());
		user.setIsEmailVerified("N");
		user.setStatus("InActive");
		user.setCreatedOn(new Date());
		user.setUpdatedOn(new Date());
		
		entityManager.persist(user);
		return user;
		
	}
	
	public UserDetails saveUserDetails(SignUpRequest signUpRequest,int UserId) {
		UserDetails userDetails = new UserDetails();
		userDetails.setAadhar(signUpRequest.getAadhar());
		userDetails.setCity(signUpRequest.getCity());
		userDetails.setRole(signUpRequest.getRole());
		signUpRequest.setUserId(UserId);
		entityManager.persist(userDetails);
		return userDetails;
	}
	
	public UserOTP saveOTPDetails(SignUpRequest signUpRequest,int UserId) {
		UserOTP userOtp = new UserOTP();
		userOtp.setUserId(UserId);
		userOtp.setGeneratedOn(new Date());
		userOtp.setOTP(SystemUtil.generateOTP());
		userOtp.setEmail(signUpRequest.getEmail());
		entityManager.persist(userOtp);
		return userOtp;
	}
}
