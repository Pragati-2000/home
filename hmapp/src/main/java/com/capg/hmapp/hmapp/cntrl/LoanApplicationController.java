package com.capg.hmapp.hmapp.cntrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hmapp.hmapp.entity.LoanApplication;
import com.capg.hmapp.hmapp.service.LoanApplicationService;


@RestController
public class LoanApplicationController {
	@Autowired
	LoanApplicationService  loanApplicationService ;

		@PostMapping("/loanApplication")

		public LoanApplication createLoanApplication(@Valid @RequestBody LoanApplication customer) {

			return loanApplicationService.createLoanApplication(customer);

		}

		@GetMapping("/loanApplication")
		 public List<LoanApplication> getLoanApplication(){

		 return loanApplicationService.getLoanApplication();

		}


		@GetMapping("/loanApplication/{id}")

		public LoanApplication getLoanApplicationById(@PathVariable int id) {

			return loanApplicationService.getLoanApplicationById(id);

		}

		@DeleteMapping("/loanApplication")

		public boolean deleteAllLoanApplication() {

			return loanApplicationService.deleteAllLoanApplication();

		}

		@DeleteMapping("/loanApplication/{id}")

		public String deleteById(@PathVariable int id) {

			return loanApplicationService.deleteById(id);

		}

	//http://localhost:8090/employees/4

		@PutMapping("/loanApplication/{id}")

		public LoanApplication updateLoanApplication(@PathVariable int id, @RequestBody LoanApplication obj) {

			return loanApplicationService.updateLoanApplication(id, obj);

		}
		@ResponseStatus(HttpStatus.BAD_REQUEST)

		 @ExceptionHandler(MethodArgumentNotValidException.class)

		 public Map<String, String> handleValidationExceptions(

		   MethodArgumentNotValidException ex) {

		     Map<String, String> errors = new HashMap<>();

		     ex.getBindingResult().getAllErrors().forEach((error) -> {

		         String fieldName = ((FieldError) error).getField();

		         String errorMessage = error.getDefaultMessage();

		         errors.put(fieldName, errorMessage);

		    });

		     return errors;

		}


}
