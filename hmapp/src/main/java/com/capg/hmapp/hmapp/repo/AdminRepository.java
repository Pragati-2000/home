package com.capg.hmapp.hmapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.hmapp.hmapp.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
