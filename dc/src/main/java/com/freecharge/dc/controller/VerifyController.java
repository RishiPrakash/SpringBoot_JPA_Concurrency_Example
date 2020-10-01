package com.freecharge.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.freecharge.dc.model.VerifyRequest;
import com.freecharge.dc.service.VerifyService;
import com.freecharge.dc.util.RequestUtil;

@RestController
@RequestMapping("/api")
public class VerifyController {

	
	@Autowired
	VerifyService verifyService;

	@PostMapping(value="/verify",produces =javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<Integer> doVerify(@RequestBody VerifyRequest verifyRequest){
		System.out.println("ApiRequest coming to signup service with request header "+RequestUtil.getHeaderInfo());
		Integer var =  verifyService.verifyUser(verifyRequest);
		return new ResponseEntity<Integer>(var,HttpStatus.OK);
	}
	
	


}
