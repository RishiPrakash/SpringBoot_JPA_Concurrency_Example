package com.freecharge.dc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.freecharge.dc.model.VerifyRequest;
import com.freecharge.dc.repository.UserOTPRepository;
import com.freecharge.dc.repository.UsersRepository;

@Service
public class VerifyService {
	
	@Autowired
	private UserOTPRepository userOTPRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int verifyUser(VerifyRequest verifyRequest) {
		
		int count = userOTPRepository.updateOTP(new Date(), verifyRequest.getOTPValue(), verifyRequest.getEmail());
		if(count>0) {
			return usersRepository.updateUser(verifyRequest.getEmail(), new Date());
		}
		return count;
	}
}
