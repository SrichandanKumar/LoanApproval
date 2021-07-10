package com.grit.LoanApproval.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grit.LoanApproval.dto.ActionDto;
import com.grit.LoanApproval.dto.EnquiryDto;
import com.grit.LoanApproval.entity.Enquiry;
import com.grit.LoanApproval.service.EnquiryService;

@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService service;
	
	
	@PostMapping("/saveEnquiry")
	public ResponseEntity<String> saveEnquiry(@RequestBody EnquiryDto enquiry){
		
	return new ResponseEntity<>("Your Enquiry id is"+" "+service.saveEnquiry(enquiry), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/takeAction")
	public ResponseEntity<String> takeAction(@RequestBody ActionDto action){
		
		return new ResponseEntity<>(service.activeStatus(action), HttpStatus.CREATED);
	}
	@GetMapping("/all-enquiries")
	public ResponseEntity<List<Enquiry>> getAllenquires(){
		
		return new ResponseEntity<>(service.getAllEnquiries(), HttpStatus.OK);
	}
}
