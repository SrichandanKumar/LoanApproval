package com.grit.LoanApproval.exception;

public class UnAuthorisedUser extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnAuthorisedUser() {
		// TODO Auto-generated constructor stub
	}
	
	public UnAuthorisedUser(String msg) {
		
		super(msg);
	}
	
}
