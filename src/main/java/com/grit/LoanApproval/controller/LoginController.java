package com.grit.LoanApproval.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grit.LoanApproval.dto.UserDto;
import com.grit.LoanApproval.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping("/login")
	public ResponseEntity<String> login(@Valid @RequestBody  UserDto user) {

		//int w=5/0;
		
		/*if(result.hasErrors()) {
			
		//	System.out.println(result.getClass().getName());
			
			return new ResponseEntity<String>("filelds are required", HttpStatus.LENGTH_REQUIRED);
		}
		*/
		return new ResponseEntity<String>(service.login(user), HttpStatus.OK);

	}

}
