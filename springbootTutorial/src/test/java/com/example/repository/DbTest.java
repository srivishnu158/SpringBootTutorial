package com.example.repository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.SpringBootTutorialApplication;
import com.example.entity.*;
import com.example.service.*;
@ContextConfiguration(classes = SpringBootTutorialApplication.class)
@DataJpaTest
class DbTest {  

	@Autowired
	DeptService dept;
	@Autowired
	Db db;
	@Autowired
	TestEntityManager entityManagerT;
	
	@BeforeEach
	void setup() {
		Entities DeptEntity = Entities.builder()
				.sid(1)
				.sname("Santhanam")
				.dept("drugs").build();
		entityManagerT.persist(DeptEntity);
	}
	@Test
	void whenFindById_thenReturnDepartment() {
		Entities ent = db.findById(1).get();
		assertEquals(ent.getDept(),"drugs");
	}

}
