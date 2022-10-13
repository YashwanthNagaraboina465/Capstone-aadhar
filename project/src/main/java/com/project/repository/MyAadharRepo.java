package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.myaadhar;

public interface MyAadharRepo extends JpaRepository<myaadhar, Integer> {

	Optional<myaadhar> findById(int id);

	
}