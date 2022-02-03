package com.capg.hmapp.hmapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hmapp.hmapp.entity.FinanceVerificationOfficer;
@Repository
public interface FinVeriOfficerRepository extends JpaRepository<FinanceVerificationOfficer, Integer>{

}
