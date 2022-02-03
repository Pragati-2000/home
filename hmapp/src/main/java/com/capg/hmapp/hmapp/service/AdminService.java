package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.Admin;
import com.capg.hmapp.hmapp.repo.AdminRepository;


@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;

	public  Admin getAdminById(int id) {
		Optional<Admin> customerContainer = adminRepository.findById(id);

		if (customerContainer.isPresent()) {

			return customerContainer.get();

		} else {

			return null;

		}
	}



	public boolean deleteAllAdmin() {
		// TODO Auto-generated method stub
		try {

			adminRepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}



	public String deleteById(int id) {
		Optional<Admin> customerContainer = adminRepository.findById(id);

		if (customerContainer.isPresent()) {

			Admin oldObj = customerContainer.get();

			adminRepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}
	}



	public  Admin updateAdmin(int id, Admin obj) {

		// I have to find the employee object having this id

		Optional<Admin> adminContainer= adminRepository.findById(id);

		if (adminContainer.isPresent()) {

			Admin oldObj = adminContainer.get();

			oldObj.setAdminName(obj.getAdminName());

			oldObj.setAdminContact(obj.getAdminContact());

			
			System.out.println("Successfully Updated!!!!!!");

			return adminRepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;
}



	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub

		return adminRepository.save(admin);
	}

	

	public List<Admin> getAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll() ;
	}

}
