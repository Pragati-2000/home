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

import com.capg.hmapp.hmapp.entity.Customer;
import com.capg.hmapp.hmapp.service.CustomerService;

@RestController

public class CustromerController {
	@Autowired
    CustomerService  customerService ;

	@PostMapping("/customer")

	public Customer createCustomer(@Valid @RequestBody Customer customer) {

		return customerService.createCustomer(customer);

	}

	@GetMapping("/customer")
	 public List<Customer> getCustomer(){

	 return customerService.getCustomer();

	}


	@GetMapping("/customer/{id}")

	public Customer getCustomerById(@PathVariable int id) {

		return customerService.getCustomerById(id);

	}

	@DeleteMapping("/customer")

	public boolean deleteAllCustomer() {

		return customerService.deleteAllCustomer();

	}

	@DeleteMapping("/customer/{id}")

	public String deleteById(@PathVariable int id) {

		return customerService.deleteById(id);

	}

//http://localhost:8090/employees/4

	@PutMapping("/customer/{id}")

	public Customer updateCustomer(@PathVariable int id, @RequestBody Customer obj) {

		return customerService.updateCustomer(id, obj);

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
