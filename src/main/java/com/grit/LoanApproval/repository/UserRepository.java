package com.grit.LoanApproval.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grit.LoanApproval.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {

	Optional<User> findByUserNameAndPassword(String userName, String password);

	
	
}
