package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Entities;
@Repository
public interface Db extends JpaRepository<Entities,Integer>{
	@Query(value="select * from Entities where snAme=?1",nativeQuery=true)
	public Entities findBySnameIgnoreCas(String name);
//	public Entities findBySid(int id);
}
