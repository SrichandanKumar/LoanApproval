package com.grit.LoanApproval.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grit.LoanApproval.entity.UserRoles;

public interface UserRoleRepository extends JpaRepository<UserRoles, Serializable> {

	public Optional<UserRoles> getByUserId(String userId); 
	
}
