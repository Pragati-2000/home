package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.LoanAgreement;
import com.capg.hmapp.hmapp.entity.LoanApplication;
import com.capg.hmapp.hmapp.exception.LoanAggrementNotFoundException;
import com.capg.hmapp.hmapp.repo.LoanAgreementRepository;
import com.capg.hmapp.hmapp.repo.LoanApplicationRepository;
@Service
public class LoanAgreementService {
	@Autowired
	LoanAgreementRepository loanAgreementRepository;
	@Autowired
	LoanApplicationRepository loanApplicationRepository;
	public LoanAgreement createLoanAgreement(LoanAgreement loan) throws LoanAggrementNotFoundException {
		LoanApplication lo =loan.getLoanApplication();
		int loanApplicationId=lo.getAppliactionId();
		if(loanApplicationId>0)
		{
			Optional<LoanApplication> loanApplicationContainer=loanApplicationRepository.findById((int) loanApplicationId);
			if(loanApplicationContainer.isPresent())
			{
				loan.setLoanApplication(loanApplicationContainer.get());
			}
			else
			{
				throw new LoanAggrementNotFoundException("LoanAggrement not found");
			}
		}
		return loanAgreementRepository.save(loan);
	}

	public List<LoanAgreement> getLoanAgreement() {
		return loanAgreementRepository.findAll() ;

	}


	public boolean deleteAllLoanAgreement() {
		try {

			loanAgreementRepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}

	public LoanAgreement getLoanAgreementById(int id) {
		Optional<LoanAgreement> loanContainer = loanAgreementRepository.findById(id);

		if (loanContainer.isPresent()) {

			return loanContainer.get();

		} else {

			return null;

		}
	}

	public String deleteById(int id) {
		Optional<LoanAgreement> loanContainer =loanAgreementRepository.findById(id);

		if (loanContainer.isPresent()) {

			LoanAgreement oldObj = loanContainer.get();

			loanAgreementRepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}

	}

	public LoanAgreement updateLoanAgreement(int id, LoanAgreement obj) {
		Optional<LoanAgreement> loanContainer= loanAgreementRepository.findById(id);

		if (loanContainer.isPresent()) {

			LoanAgreement oldObj = loanContainer.get();

			oldObj.setLoanAggrementId(obj.getLoanAggrementId());

			oldObj.setLoanApplication(obj.getLoanApplication());

			
			System.out.println("Successfully Updated!!!!!!");

			return loanAgreementRepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;

	}

}
