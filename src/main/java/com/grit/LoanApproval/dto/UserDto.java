package com.grit.LoanApproval.dto;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {

	private String userId;
	
	@NotNull(message="UserName Should not Null")
	@Size(min=4,max=12,message="UserName Should between 4 to 12")
	private String userName;

	@NotNull(message="password Should not Null")
	@Size(min=5,max=12,message="UserName Should between 5 to 12")
	private String password;
}
