package com.grit.LoanApproval.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id

	private String userId;

	private String userName;

	private String password;

	/*@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "user_roles",
    joinColumns = { @JoinColumn(name = "userId") },
    inverseJoinColumns = { @JoinColumn(name = "roleId") })
	private List<Role> roles;*/
}
