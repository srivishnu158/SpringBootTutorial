package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Entities;
import com.example.error.DeptNotFoundException;
import com.example.repository.Db;
import com.example.service.DeptService;
import com.example.service.ServiceRep;

import jakarta.validation.Valid;

@RestController
public class Controller1 {
	@Autowired
	DeptService reqService;
	@Autowired
	Db db;
	@PostMapping("/dept")
	public Entities saveDetails( @RequestBody Entities det) {
//		return db.save(det);
		return reqService.saveDetails(det);
	}
	
	@GetMapping("/getDept/{id}")
	
	public Entities get(@PathVariable int id) throws DeptNotFoundException {
		return reqService.get(id);
	}
	@GetMapping("/getbyname/{name}")
	public Entities getByName(@PathVariable String name) {
		return reqService.getByName(name);
	}
//	
//	
//	@DeleteMapping("/delDept/{id}")
//	public String delete(@PathVariable int id) {
//		return reqService.delete(id);
//	}
//	
//	@PutMapping("/putDept/{id}")
//	public Entities put(@PathVariable int id,@RequestBody Entities data) {
//		return reqService.put(id,data);
//	}
}
