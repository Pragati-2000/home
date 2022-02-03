package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.User;
import com.capg.hmapp.hmapp.repo.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	

	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll() ;
	}




	public  User getUserById(int id) {
		Optional<User> userContainer = userRepository.findById(id);

		if (userContainer.isPresent()) {

			return userContainer.get();

		} else {

			return null;

		}
	}



	public boolean deleteAllUser() {
		// TODO Auto-generated method stub
		try {

			userRepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}



	public String deleteById(int id) {
		Optional<User> userContainer = userRepository.findById(id);

		if (userContainer.isPresent()) {

			User oldObj = userContainer.get();

			userRepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}
		
	}



	public  User updateUser(int id, User obj) {

		// I have to find the employee object having this id

		Optional<User> userContainer = userRepository.findById(id);

		if (userContainer.isPresent()) {

			User oldObj = userContainer.get();

			oldObj.setPassword(obj.getPassword());

			oldObj.setRole(obj.getRole());

			System.out.println("Successfully Updated!!!!!!");

			return userRepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;
	}

}
