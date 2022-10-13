package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.myaadhar;
import com.project.exceptions.UserNotFoundException;
import com.project.repository.MyAadharRepo;

@Service
public class AadharService {

	private final MyAadharRepo repo;

	@Autowired
	public AadharService(MyAadharRepo repo) {
		this.repo = repo;
	}
	
	public List<myaadhar> findallRecords(){
		return repo.findAll();
	}

	public myaadhar add(myaadhar x) {
		return repo.save(x);
	}

	public myaadhar update(myaadhar x) {
		return repo.save(x);
	}

	public myaadhar findmyaadharById(int id) {
		return repo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " not found"));

	}

	public void delete(int id) {
		repo.deleteById(id);
	}

}