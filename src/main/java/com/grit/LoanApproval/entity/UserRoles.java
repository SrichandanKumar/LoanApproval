package com.grit.LoanApproval.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="User_Roles")
public class UserRoles {

	
	@Id
	private String id;
	private String userId;
	
	private String roleId;
	
}
