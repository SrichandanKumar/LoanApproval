package com.grit.LoanApproval.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Enquiry {

	@Id
	private String enquiryId;
	
	private String customerName;
	private String jobType;
	private BigDecimal loanAmount;
	private BigDecimal intrestRate;
	
	private String userId;
	private String status;
	
}
