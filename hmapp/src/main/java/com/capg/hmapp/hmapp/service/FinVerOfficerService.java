package com.capg.hmapp.hmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hmapp.hmapp.entity.FinanceVerificationOfficer;
import com.capg.hmapp.hmapp.repo.FinVeriOfficerRepository;


@Service
public class FinVerOfficerService {
	@Autowired
	FinVeriOfficerRepository finVeriOfficerRepository;
	

	public  FinanceVerificationOfficer getFinVerOfficerById(int id) {
		Optional<FinanceVerificationOfficer> finVeriOfficerContainer = finVeriOfficerRepository.findById(id);

		if (finVeriOfficerContainer.isPresent()) {

			return finVeriOfficerContainer.get();

		} else {

			return null;

		}
	}



	public boolean deleteAllFinVerOfficer() {
		// TODO Auto-generated method stub
		try {

			finVeriOfficerRepository.deleteAll();

		} catch (Exception e) {

			return false;

		}

		return true;
	}



	public String deleteById(int id) {
		Optional<FinanceVerificationOfficer> finVeriOfficerContainer = finVeriOfficerRepository.findById(id);

		if (finVeriOfficerContainer.isPresent()) {

			FinanceVerificationOfficer oldObj = finVeriOfficerContainer.get();

			finVeriOfficerRepository.delete(oldObj);

			return "Deleted Successfully!!!";

		} else {

			return "The specified id is not present in the DB :" + id;

		}
	}



	public FinanceVerificationOfficer updateFinVerOfficer(int id, FinanceVerificationOfficer obj) {

		// I have to find the employee object having this id

		Optional<FinanceVerificationOfficer> finVeriOfficerContainer= finVeriOfficerRepository.findById(id);

		if (finVeriOfficerContainer.isPresent()) {

			FinanceVerificationOfficer oldObj = finVeriOfficerContainer.get();

			oldObj.setFinOfficerName(obj.getFinOfficerName());

			oldObj.setFinOfficerContact(obj.getFinOfficerContact());

			
			System.out.println("Successfully Updated!!!!!!");

			return finVeriOfficerRepository.saveAndFlush(oldObj);

		}

		System.out.println("No object Found with this ID");

		return obj;
}



	public FinanceVerificationOfficer createFinVerOfficer(FinanceVerificationOfficer fin) {
		// TODO Auto-generated method stub

		return finVeriOfficerRepository.save(fin);
	}

	

	public List<FinanceVerificationOfficer> getFinVerOfficer() {
		// TODO Auto-generated method stub
		return finVeriOfficerRepository.findAll() ;
	}

}
