package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.LandVerificationOfficer;
import com.capg.hmapp.hmapp.repo.LandVerOfficerRepository;


@Service
public class LandVerOfficerService {
	@Autowired
	LandVerOfficerRepository landVerOfficerRepository;

	public  LandVerificationOfficer getLandVerOfficerById(int id) {
		Optional<LandVerificationOfficer> EMIContainer = landVerOfficerRepository.findById(id);

		if (EMIContainer.isPresent()) {

			return EMIContainer.get();

		} else {

			return null;

		}
	}



	public boolean deleteAllLandVerOfficer() {
		// TODO Auto-generated method stub
		try {

			landVerOfficerRepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}



	public String deleteById(int id) {
		Optional<LandVerificationOfficer> EMIContainer = landVerOfficerRepository.findById(id);

		if (EMIContainer.isPresent()) {

			LandVerificationOfficer oldObj = EMIContainer.get();

			landVerOfficerRepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}
	}



	public LandVerificationOfficer updateLandVerificationOfficer(int id, LandVerificationOfficer obj) {

		// I have to find the employee object having this id

		Optional<LandVerificationOfficer> EMIContainer= landVerOfficerRepository.findById(id);

		if (EMIContainer.isPresent()) {

			LandVerificationOfficer oldObj = EMIContainer.get();

			oldObj.setOfficerName(obj.getOfficerName());

			oldObj.setOfficerContact(obj.getOfficerContact());

			

			System.out.println("Successfully Updated!!!!!!");

			return landVerOfficerRepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;
}



	public LandVerificationOfficer createLandVerificationOfficer(LandVerificationOfficer emi) {
		// TODO Auto-generated method stub

		return landVerOfficerRepository.save(emi);
	}

	

	public List<LandVerificationOfficer> getLandVerificationOfficer() {
		// TODO Auto-generated method stub
		return landVerOfficerRepository.findAll() ;
	}

}
