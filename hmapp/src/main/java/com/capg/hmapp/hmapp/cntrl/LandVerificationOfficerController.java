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

import com.capg.hmapp.hmapp.entity.LandVerificationOfficer;
import com.capg.hmapp.hmapp.service.LandVerOfficerService;
@RestController


public class LandVerificationOfficerController {
	@Autowired
	LandVerOfficerService landVerOfficerService;
		@PostMapping("/landofficer")

		public LandVerificationOfficer createLandVerificationOfficer(@Valid @RequestBody LandVerificationOfficer customer) {

			return landVerOfficerService.createLandVerificationOfficer(customer);

		}

		@GetMapping("/landofficer")
		 public List<LandVerificationOfficer> getLandVerificationOfficerr(){

		 return landVerOfficerService.getLandVerificationOfficer();

		}


		@GetMapping("/landofficer/{id}")

		public LandVerificationOfficer getLandVerOfficerById(@PathVariable int id) {

			return landVerOfficerService.getLandVerOfficerById(id);

		}

		@DeleteMapping("/landofficer")

		public boolean deleteAllLandVerfficer() {

			return landVerOfficerService.deleteAllLandVerOfficer();

		}

		@DeleteMapping("/landofficer/{id}")

		public String deleteById(@PathVariable int id) {

			return landVerOfficerService.deleteById(id);

		}

	//http://localhost:8090/employees/4

		@PutMapping("/landofficer/{id}")

		public LandVerificationOfficer updateLandVerificationOfficer(@PathVariable int id, @RequestBody LandVerificationOfficer obj) {

			return landVerOfficerService.updateLandVerificationOfficer(id, obj);

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
