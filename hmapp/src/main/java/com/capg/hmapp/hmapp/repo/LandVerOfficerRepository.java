package com.capg.hmapp.hmapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hmapp.hmapp.entity.LandVerificationOfficer;


@Repository

public interface LandVerOfficerRepository extends JpaRepository<LandVerificationOfficer, Integer>{

}
