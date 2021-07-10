package com.grit.LoanApproval.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grit.LoanApproval.dto.ActionDto;
import com.grit.LoanApproval.dto.EnquiryDto;
import com.grit.LoanApproval.entity.Enquiry;
import com.grit.LoanApproval.entity.Role;
import com.grit.LoanApproval.entity.UserRoles;
import com.grit.LoanApproval.exception.ResourceNotCreatedException;
import com.grit.LoanApproval.repository.EnquiryRepository;
import com.grit.LoanApproval.repository.RoleRepository;
import com.grit.LoanApproval.repository.UserRoleRepository;

@Service
public class EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private RoleRepository roleRepository;

	public String saveEnquiry(EnquiryDto enquiry) {

		Optional<UserRoles> byUserId = userRoleRepository.getByUserId(enquiry.getUserId());
		if (byUserId.isPresent()) {
			Optional<Role> role = roleRepository.findById(byUserId.get().getRoleId());
			if (role.isPresent()&& role.get().getRole().equals("Role1")) {
				Enquiry entity = new Enquiry();
				BeanUtils.copyProperties(enquiry, entity);
				if (enquiry.getIntrestRate().compareTo(new BigDecimal(16)) == 1) {
					entity.setStatus("Approve");

				}

				Enquiry savedEntity = enquiryRepository.save(entity);
				if (savedEntity != null)

					return savedEntity.getEnquiryId();
				else
					return "unable to save";

			} else
				throw new ResourceNotCreatedException("User Role Not found");
		} else
			throw new ResourceNotCreatedException("User Not found");

	}

	public String activeStatus(ActionDto enquiry) {
		Optional<Enquiry> savedEnquiry = enquiryRepository.findById(enquiry.getEnquiryId());
		if (savedEnquiry.isPresent()) {
			Optional<UserRoles> byUserId = userRoleRepository.getByUserId(enquiry.getUserId());
			if (byUserId.isPresent()) {
				Optional<Role> role = roleRepository.findById(byUserId.get().getRoleId());
				if (role.isPresent()) {
					if (savedEnquiry.get().getIntrestRate().compareTo(BigDecimal.valueOf(14.00))>0 && savedEnquiry.get().getIntrestRate().compareTo(BigDecimal.valueOf(16.00))<0 && role.get().getRole().equals("Role2")) {
						System.out.println(savedEnquiry.get());
						return takeAction(savedEnquiry,"Approve");
					} else if (savedEnquiry.get().getIntrestRate().compareTo(BigDecimal.valueOf(12.00))>0 && savedEnquiry.get().getIntrestRate().compareTo(BigDecimal.valueOf(14.00))<0) {
						if (role.get().getRole().equals("Role2")) {
							return takeAction(savedEnquiry,"Recommend");
						}else if (role.get().getRole().equals("Role3"))
							return takeAction(savedEnquiry,"Approve");
						else
							return " No Action Taken";
					} else if (savedEnquiry.get().getIntrestRate().compareTo(BigDecimal.valueOf(12.00))<0) {
						if (role.get().getRole().equals("Role2"))
							return takeAction(savedEnquiry,"Recommend");
						else if (role.get().getRole().equals("Role3"))
							return takeAction(savedEnquiry,"Recommend");
						else if (role.get().getRole().equals("Role4"))
							return takeAction(savedEnquiry,"Approve");
						else
							return " No Action Taken";
					}
					else
						return "No Action taken";
				} else
					throw new ResourceNotCreatedException("User Role Not found");
			} else
				throw new ResourceNotCreatedException("User Not found");
		} else
			throw new ResourceNotCreatedException("Enquiry Not found");
	}

	private String takeAction(Optional<Enquiry> savedEnquiry,String status) {
		savedEnquiry.get().setStatus(status);
		enquiryRepository.save(savedEnquiry.get());
		return "Action taken";
	}

	public List<Enquiry> getAllEnquiries() {
		return enquiryRepository.findAll();
	}
}