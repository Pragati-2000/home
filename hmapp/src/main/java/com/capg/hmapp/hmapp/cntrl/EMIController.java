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

import com.capg.hmapp.hmapp.entity.EMI;
import com.capg.hmapp.hmapp.exception.LoanAggrementNotFoundException;
import com.capg.hmapp.hmapp.service.EMIService;

@RestController

public class EMIController {
	@Autowired
    EMIService  emiService ;

@PostMapping("/EMI")

public EMI createEMI(@Valid @RequestBody EMI emi) throws LoanAggrementNotFoundException {

	return emiService.createEMI(emi);

}

@GetMapping("/EMI")
 public List<EMI> getEMI(){

 return emiService.getEMI();

}


@GetMapping("/EMI/{id}")

public EMI getEMIById(@PathVariable int id) {

	return emiService.getEMIById(id);

}

@DeleteMapping("/EMI")

public boolean deleteAllEMI() {

	return emiService.deleteAllEMI();

}

@DeleteMapping("/EMI/{id}")

public String deleteById(@PathVariable int id) {

	return emiService.deleteById(id);

}

//http://localhost:8090/employees/4

@PutMapping("/EMI/{id}")

public EMI updateEMI(@PathVariable int id, @RequestBody EMI obj) {

	return emiService.updateEMI(id, obj);

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
