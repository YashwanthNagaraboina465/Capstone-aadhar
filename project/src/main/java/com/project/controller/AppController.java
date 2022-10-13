package com.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.myaadhar;
import com.project.service.AadharService;

@RestController
@RequestMapping("/aadhar")
public class AppController {
	
	private final AadharService aadharservice;
	
	public AppController(AadharService aadharservice) {
		this.aadharservice=aadharservice;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<myaadhar>> getalldetails(){
		List<myaadhar> records=aadharservice.findallRecords();
		return new ResponseEntity<>(records,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<myaadhar> getaadharById(@PathVariable("id") int id){
		myaadhar x=aadharservice.findmyaadharById(id);
		return new ResponseEntity<>(x,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	ResponseEntity<myaadhar> addRequest(@RequestBody  myaadhar x){
		myaadhar y=aadharservice.add(x);
		return new ResponseEntity<>(y,HttpStatus.CREATED);
		
	}
	//for updating
	@PutMapping("/update")
	ResponseEntity<myaadhar> updateRequest(@RequestBody  myaadhar x){
		myaadhar y=aadharservice.update(x);
		return new ResponseEntity<>(y,HttpStatus.OK);
		
	}
	//for death
	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> deleteRequest(@PathVariable("id") int id){
		aadharservice.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	

}