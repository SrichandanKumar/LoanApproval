package com.grit.LoanApproval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grit.LoanApproval.dto.ActionDto;
import com.grit.LoanApproval.dto.EnquiryDto;
import com.grit.LoanApproval.service.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService service;
	
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody EnquiryDto enquiry){
		
	return new ResponseEntity<String>("Your Enquiry id is"+" "+service.saveEnquiry(enquiry), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/takeAction")
	public ResponseEntity<String> takeAction(@RequestBody ActionDto action){
		
		return new ResponseEntity<String>(service.activeStatus(action), HttpStatus.CREATED);
	}
	
}
