package com.example.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.example.entity.Entities;
import com.example.repository.*;
import com.example.demo.*;

@ContextConfiguration(classes = SpringBootTutorialApplication.class)
@SpringBootTest
class DeptServiceTest {
	@Autowired
	DeptService deptServ;
	@MockBean
	Db db;
	@BeforeEach
	void setup() {
		Entities ent = Entities.builder()
				.sid(10)
				.sname("ram")
				.dept("cse").build();
		Mockito.when(db.findBySnameIgnoreCas("ram")).thenReturn(ent);		
	}
	
	@Test
	@DisplayName("nameN")
//	@Disabled
	public void IfDeptNameIsValid_DeptShouldBeFound() {
		String sname = "ram";
		Entities ret_name = deptServ.getByName(sname);
		assertEquals(sname,ret_name.getSname());
		
	}
	
}
