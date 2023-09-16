package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Entities;
import com.example.error.DeptNotFoundException;
import com.example.repository.Db;
@Service
public class DeptService implements ServiceRep{
	@Autowired
	Db DeptRep;
	@Override
	public Entities saveDetails(Entities det) {
		return DeptRep.save(det);
	}
	public Entities get(int id) throws DeptNotFoundException {
		Optional<Entities> option = DeptRep.findById(id);
		if(!option.isPresent()) {
			throw new DeptNotFoundException("Department you are trying to find doesn't exist");
		}
		return DeptRep.findById(id).get();
	}
	
	public Entities getById(int id) {
		return DeptRep.findById(id).get();
	}
	
	public String delete(int id) {
		DeptRep.deleteById(id);
		return "deleted";
	}
	public Entities put(int id, Entities data) {
		Entities prev = DeptRep.findById(id).get();
		if(data != null) {
			if(!data.getSname().equalsIgnoreCase(""))
				prev.setSname(data.getSname());
			if(!data.getDept().equalsIgnoreCase(""))
				prev.setDept(data.getDept());
			return DeptRep.save(prev);
			
		}
		return null;
	}
	public Entities getByName(String name) {
		return DeptRep.findBySnameIgnoreCas(name);
	}
	
}   