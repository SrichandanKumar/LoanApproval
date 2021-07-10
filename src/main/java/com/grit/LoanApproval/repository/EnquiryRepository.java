package com.grit.LoanApproval.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grit.LoanApproval.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Serializable> {

}
