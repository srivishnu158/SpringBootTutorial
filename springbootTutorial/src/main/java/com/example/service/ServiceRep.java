package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Entities;
@Service
public interface ServiceRep {
	public Entities saveDetails(Entities det);
}
