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

import com.capg.hmapp.hmapp.entity.Admin;
import com.capg.hmapp.hmapp.service.AdminService;


@RestController
public class AdminController {
	@Autowired
	AdminService  adminService ;
	@PostMapping("/admin")

	public Admin createAdmin(@Valid @RequestBody Admin admin) {

		return adminService.createAdmin(admin);

	}

	@GetMapping("/admin")
	 public List<Admin> getAdmin(){

	 return adminService.getAdmin();

	}


	@GetMapping("/admin/{id}")

	public Admin getAdminById(@PathVariable int id) {

		return adminService.getAdminById(id);

	}

	@DeleteMapping("/admin")

	public boolean deleteAllAdmin() {

		return adminService.deleteAllAdmin();

	}

	@DeleteMapping("/admin/{id}")

	public String deleteById(@PathVariable int id) {

		return adminService.deleteById(id);

	}

//http://localhost:8090/employees/4

	@PutMapping("/admin/{id}")

	public Admin updateAdmin(@PathVariable int id, @RequestBody Admin obj) {

		return adminService.updateAdmin(id, obj);

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
