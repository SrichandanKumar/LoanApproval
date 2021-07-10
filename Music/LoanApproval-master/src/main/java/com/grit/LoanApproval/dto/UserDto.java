package com.grit.LoanApproval.dto;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserDto {

	private String userId;
	
	@NotNull(message="UserName Should not Null")
	@Size(min=4,max=12,message="UserName Should between 4 to 12")
	private String userName;

	@NotNull(message="password Should not Null")
	@Size(min=5,max=12,message="UserName Should between 5 to 12")
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
