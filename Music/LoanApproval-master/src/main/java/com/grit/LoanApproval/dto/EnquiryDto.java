package com.grit.LoanApproval.dto;

import java.math.BigDecimal;


public class EnquiryDto {

	private String enquiryId;

	private String customerName;
	private String jobType;
	private BigDecimal loanAmount;
	private BigDecimal intrestRate;

	private String userId;
	private String status;
	public String getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(String enquiryId) {
		this.enquiryId = enquiryId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public BigDecimal getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(BigDecimal intrestRate) {
		this.intrestRate = intrestRate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
