package com.grit.LoanApproval.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Role {

	@Id
	private String roleId;
	private String role;
	
	/*@ManyToMany(mappedBy="roles",fetch=FetchType.LAZY)
	private List<User> users=new ArrayList<User>();*/
}
