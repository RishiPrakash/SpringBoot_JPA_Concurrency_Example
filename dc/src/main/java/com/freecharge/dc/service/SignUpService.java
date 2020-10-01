package com.freecharge.dc.service;

import java.lang.module.ModuleDescriptor.Requires;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freecharge.dc.entitymodel.UserOTP;
import com.freecharge.dc.entitymodel.Users;
import com.freecharge.dc.model.SignUpRequest;
import com.freecharge.dc.model.SignUpResponse;
import com.freecharge.dc.model.VerifyRequest;
import com.freecharge.dc.model.VerifyResponse;
import com.freecharge.dc.repository.SignUpRepository;


@Service
public class SignUpService {
		
	@Autowired
	private SignUpRepository userRepository;
	
	public SignUpResponse doSingUp(SignUpRequest signUpRequest) {
		
		UserOTP userOTP = userRepository.save(signUpRequest);
		SignUpResponse signUpResponse = new SignUpResponse();
		signUpResponse.setOTP(userOTP.getOTP());
		signUpResponse.setCreatedAt(userOTP.getGeneratedOn());
		return signUpResponse;
	}
	
	
}
