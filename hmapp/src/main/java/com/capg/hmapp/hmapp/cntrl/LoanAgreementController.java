package com.capg.hmapp.hmapp.cntrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hmapp.hmapp.entity.LoanAgreement;
import com.capg.hmapp.hmapp.exception.LoanAggrementNotFoundException;
import com.capg.hmapp.hmapp.service.LoanAgreementService;

@RestController
public class LoanAgreementController {
	@Autowired
	LoanAgreementService  loanAgreementService ;

		@PostMapping("/loanAgreement")

		public LoanAgreement createLoanAgreement(@RequestBody LoanAgreement loan) throws LoanAggrementNotFoundException {

			return loanAgreementService.createLoanAgreement(loan);

		}

		@GetMapping("/loanAgreement")
		 public List<LoanAgreement> getLoanAgreement(){

		 return loanAgreementService.getLoanAgreement();

		}


		@GetMapping("/loanAgreement/{id}")

		public LoanAgreement getLoanAgreementById(@PathVariable int id) {

			return loanAgreementService.getLoanAgreementById(id);

		}

		@DeleteMapping("/loanAgreement")

		public boolean deleteAllLoanAgreement() {

			return loanAgreementService.deleteAllLoanAgreement();

		}

		@DeleteMapping("/loanAgreement/{id}")

		public String deleteById(@PathVariable int id) {

			return loanAgreementService.deleteById(id);

		}

	//http://localhost:8090/employees/4

		@PutMapping("/loanAgreement/{id}")

		public LoanAgreement updateLoanAgreement(@PathVariable int id, @RequestBody LoanAgreement obj) {

			return loanAgreementService.updateLoanAgreement(id, obj);

		}
		

}
