package com.example.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.SpringBootTutorialApplication;
import com.example.entity.*;
import com.example.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.repository.*;
import com.example.controller.Controller1;
import com.example.demo.*;
//@ContextConfiguration(classes = SpringBootTutorialApplicationTests.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootTutorialApplication.class)
//@SpringJUnitConfig
//@WebMvcTest(controllers=Controller1.class)
@AutoConfigureMockMvc
//@ExtendWith(MockitoExtension.class)
class Controller1Test {

	@Autowired
	MockMvc Mockmvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	DeptService serv;
	private Entities dept;
	@BeforeEach
	void setUp() throws Exception {
		dept = Entities.builder()
				.sid(1)
				.sname("ram")
				.dept("ece").build();	
	}

	@Test
	void testSaveDetails() throws Exception {
//		String json = ""
		Entities input_dept = Entities.builder()
				.sname("ram")
				.dept("ece").build();
		Mockito.when(serv.saveDetails(input_dept)).thenReturn(dept);
		Mockmvc.perform(MockMvcRequestBuilders.post("/dept")
		.contentType(MediaType.APPLICATION_JSON)
//		.content(toJson(json))
		.content("{\n"+
		    "\t\"sname\":\"ram\",\n"+
		    "\t\"dept\":\"ece\"\n"+
		"}"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("$.dept",is("ece")));
//		fail("Not yet implemented");
	}
	@Test
//	@Disabled
	void testGet() throws Exception {
		Mockito.when(serv.get(1)).thenReturn(dept);
		Mockmvc.perform(MockMvcRequestBuilders.get("/getDept/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.dept")
				.value(dept.getDept()));
	}

}
