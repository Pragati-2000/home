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

import com.capg.hmapp.hmapp.entity.FinanceVerificationOfficer;
import com.capg.hmapp.hmapp.service.FinVerOfficerService;

@RestController

public class FinVeriOfficerController {
	@Autowired
	FinVerOfficerService  finVerOfficerService ;

		@PostMapping("/finVerOfficer")

		public FinanceVerificationOfficer createFinVerOfficer(@Valid @RequestBody FinanceVerificationOfficer fin) {

			return finVerOfficerService.createFinVerOfficer(fin);

		}

		@GetMapping("/finVerOfficer")
		 public List<FinanceVerificationOfficer> getFinVerOfficer(){

		 return finVerOfficerService.getFinVerOfficer();

		}


		@GetMapping("/finVerOfficer/{id}")

		public FinanceVerificationOfficer getFinVerOfficerById(@PathVariable int id) {

			return finVerOfficerService.getFinVerOfficerById(id);

		}

		@DeleteMapping("/finVerOfficer")

		public boolean deleteAllFinVerOfficer() {

			return finVerOfficerService.deleteAllFinVerOfficer();

		}

		@DeleteMapping("/finVerOfficer/{id}")

		public String deleteById(@PathVariable int id) {

			return finVerOfficerService.deleteById(id);

		}

	//http://localhost:8090/employees/4

		@PutMapping("/finVerOfficer/{id}")

		public FinanceVerificationOfficer updateFinVerOfficer(@PathVariable int id, @RequestBody FinanceVerificationOfficer obj) {

			return finVerOfficerService.updateFinVerOfficer(id, obj);

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
