package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.EMI;
import com.capg.hmapp.hmapp.entity.LoanAgreement;
import com.capg.hmapp.hmapp.exception.LoanAggrementNotFoundException;
import com.capg.hmapp.hmapp.repo.EMIRepository;
import com.capg.hmapp.hmapp.repo.LoanAgreementRepository;


@Service
public class EMIService {
	@Autowired
	EMIRepository EMIrepository;
	@Autowired
	LoanAgreementRepository loanAgreementRepository;


	public  EMI getEMIById(int id) {
		Optional<EMI> EMIContainer = EMIrepository.findById(id);

		if (EMIContainer.isPresent()) {

			return EMIContainer.get();

		} else {

			return null;

		}
	}



	public boolean deleteAllEMI() {
		// TODO Auto-generated method stub
		try {

			EMIrepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}



	public String deleteById(int id) {
		Optional<EMI> EMIContainer = EMIrepository.findById(id);

		if (EMIContainer.isPresent()) {

			EMI oldObj = EMIContainer.get();

			EMIrepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}
	}



	public  EMI updateEMI(int id, EMI obj) {

		// I have to find the employee object having this id

		Optional<EMI> EMIContainer= EMIrepository.findById(id);

		if (EMIContainer.isPresent()) {

			EMI oldObj = EMIContainer.get();

			oldObj.setDueDate(obj.getDueDate());

			oldObj.setEmiAmount(obj.getEmiAmount());

			oldObj.setLoanAmount(obj.getLoanAmount());

			oldObj.setInterestAmount(obj.getInterestAmount());

			oldObj.setLoanAggrement(obj.getLoanAggrement());
			

			System.out.println("Successfully Updated!!!!!!");

			return EMIrepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;
}



	public EMI createEMI(EMI emi) throws LoanAggrementNotFoundException {
		LoanAgreement loanAgg = emi.getLoanAggrement();
		long loanAgreementId=loanAgg.getLoanAggrementId();
		if(loanAgreementId>0)
		{
			Optional<LoanAgreement> loanAggrementContainer=loanAgreementRepository.findById((int) loanAgreementId);
			if(loanAggrementContainer.isPresent())
			{
				emi.setLoanAggrement(loanAggrementContainer.get());
			}
			else
			{
				throw new LoanAggrementNotFoundException("LoanAggrement not found");
			}
		}
		// TODO Auto-generated method stub

		return EMIrepository.save(emi);
	}

	

	public List<EMI> getEMI() {
		
		// TODO Auto-generated method stub
		return EMIrepository.findAll() ;
	}

}
