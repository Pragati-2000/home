package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.Customer;
import com.capg.hmapp.hmapp.repo.CustomerRepository;


@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;




	public  Customer getCustomerById(int id) {
		Optional<Customer> customerContainer = customerRepository.findById(id);

		if (customerContainer.isPresent()) {

			return customerContainer.get();

		} else {

			return null;

		}
	}



	public boolean deleteAllCustomer() {
		// TODO Auto-generated method stub
		try {

			customerRepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}



	public String deleteById(int id) {
		Optional<Customer> customerContainer = customerRepository.findById(id);

		if (customerContainer.isPresent()) {

			Customer oldObj = customerContainer.get();

			customerRepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}
	}



	public  Customer updateCustomer(int id, Customer obj) {

		// I have to find the employee object having this id

		Optional<Customer> customerContainer= customerRepository.findById(id);

		if (customerContainer.isPresent()) {

			Customer oldObj = customerContainer.get();

			oldObj.setCustomerName(obj.getCustomerName());

			oldObj.setMobileNumber(obj.getMobileNumber());

			oldObj.setEmailId(obj.getEmailId());

			oldObj.setDateOfBirth(obj.getDateOfBirth());

			oldObj.setGender(obj.getGender());
			oldObj.setNationality(obj.getNationality());
			oldObj.setAadharNumber(obj.getAadharNumber());
			oldObj.setPanNumber(obj.getPanNumber());

			System.out.println("Successfully Updated!!!!!!");

			return customerRepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;
}



	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub

		return customerRepository.save(customer);
	}

	

	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll() ;
	}

}
