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

import com.capg.hmapp.hmapp.entity.User;
import com.capg.hmapp.hmapp.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService userService;
	

	@PostMapping("/user")

	public User createUser(@Valid @RequestBody User user) {

		return userService.createUser(user);

	}

	@GetMapping("/user")
	 public List<User> getUser(){

	 return userService.getUser();

	}


	@GetMapping("/user/{id}")

	public User getUserById(@PathVariable int id) {

		return userService.getUserById(id);

	}

	@DeleteMapping("/user")

	public boolean deleteAllUser() {

		return userService.deleteAllUser();

	}

	@DeleteMapping("/user/{id}")

	public String deleteById(@PathVariable int id) {

		return userService.deleteById(id);

	}

//http://localhost:8090/employees/4

	@PutMapping("/user/{id}")

	public User updateUser(@PathVariable int id, @RequestBody User obj) {

		return userService.updateUser(id, obj);

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
