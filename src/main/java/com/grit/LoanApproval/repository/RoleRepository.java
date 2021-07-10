package com.grit.LoanApproval.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grit.LoanApproval.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable> {

}
