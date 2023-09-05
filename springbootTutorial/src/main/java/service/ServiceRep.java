package service;

import org.springframework.stereotype.Service;

import entity.Entities;
@Service
public interface ServiceRep {
	public Entities saveDetails(Entities det);
}
