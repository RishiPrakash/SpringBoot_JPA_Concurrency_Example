package com.freecharge.dc.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.dc.model.SignUpResponse;
import com.freecharge.dc.model.VerifyRequest;
import com.freecharge.dc.model.VerifyResponse;
import com.freecharge.dc.service.SignUpService;
import com.freecharge.dc.service.VerifyService;
import com.freecharge.dc.util.RequestUtil;
import com.freecharge.dc.model.SignUpRequest;



@RestController
@RequestMapping("/api")
public class SignUpController {
	
	@Autowired
	SignUpService signUpService;
	
	@Autowired
	VerifyService verifyService;

	@PostMapping(value="/signup",produces =javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<SignUpResponse> doSignUp(@RequestBody SignUpRequest singUpRequest){
		
		System.out.println("ApiRequest coming to signup service with request header "+RequestUtil.getHeaderInfo());
		SignUpResponse signUpResponse =  signUpService.doSingUp(singUpRequest);
		return new ResponseEntity<SignUpResponse>(signUpResponse,HttpStatus.OK);
	}
	
	
	
}

