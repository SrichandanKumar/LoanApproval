package com.grit.LoanApproval.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EnquiryDto {

	private String enquiryId;

	private String customerName;
	private String jobType;
	private BigDecimal loanAmount;
	private BigDecimal intrestRate;

	private String userId;
	private String status;

}
