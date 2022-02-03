package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.LoanApplication;
import com.capg.hmapp.hmapp.repo.LoanApplicationRepository;


@Service
public class LoanApplicationService {
	@Autowired
	LoanApplicationRepository loanApplicationRepository;

	public  LoanApplication getLoanApplicationById(int id) {
		Optional<LoanApplication> customerContainer = loanApplicationRepository.findById(id);

		if (customerContainer.isPresent()) {

			return customerContainer.get();

		} else {

			return null;

		}
	}



	public boolean deleteAllLoanApplication() {
		// TODO Auto-generated method stub
		try {

			loanApplicationRepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}



	public String deleteById(int id) {
		Optional<LoanApplication> customerContainer = loanApplicationRepository.findById(id);

		if (customerContainer.isPresent()) {

			LoanApplication oldObj = customerContainer.get();

			loanApplicationRepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}
	}



	public LoanApplication updateLoanApplication(int id, LoanApplication obj) {

		// I have to find the employee object having this id

		Optional<LoanApplication> adminContainer= loanApplicationRepository.findById(id);

		if (adminContainer.isPresent()) {

			LoanApplication oldObj = adminContainer.get();

			oldObj.setApplicationDate(obj.getApplicationDate());
			oldObj.setLoanAppliedAmount(obj.getLoanAppliedAmount());
			oldObj.setLoanApprovedAmount(obj.getLoanApprovedAmount());
			oldObj.setFinanceVerificationApproval(obj.isFinanceVerificationApproval());
			oldObj.setLandVerificationApproval(obj.isLandVerificationApproval());
			oldObj.setAdminApproval(obj.isAdminApproval());
			oldObj.setStatus(obj.getStatus());
			
			System.out.println("Successfully Updated!!!!!!");

			return loanApplicationRepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;
}



	public LoanApplication createLoanApplication(LoanApplication admin) {
		// TODO Auto-generated method stub

		return loanApplicationRepository.save(admin);
	}

	

	public List<LoanApplication> getLoanApplication() {
		// TODO Auto-generated method stub
		return loanApplicationRepository.findAll() ;
	}

}
