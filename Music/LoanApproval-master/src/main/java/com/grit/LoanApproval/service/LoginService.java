package com.grit.LoanApproval.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grit.LoanApproval.dto.UserDto;
import com.grit.LoanApproval.entity.User;
import com.grit.LoanApproval.exception.UnAuthorisedUser;
import com.grit.LoanApproval.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String login(UserDto user) {
		
		//User userEntity=new User();
		//BeanUtils.copyProperties(user, userEntity);
		
		Optional<User> getUser = userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
		
		if(getUser.isPresent()) {
			return "Login Successfull";
		}
		
		//need to change with encrypted password
		else {
		throw new UnAuthorisedUser("Invalid Login Credentials");
	}

	}
}
