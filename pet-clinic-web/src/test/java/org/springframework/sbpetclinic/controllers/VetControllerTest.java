package org.springframework.sbpetclinic.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.service.VetService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

	@InjectMocks
	VetController controller;

	@Mock
	VetService service;

	MockMvc mockMvc;

	Set<Vet> vets;

	@BeforeEach
	void setUp() throws Exception {
		vets = new HashSet<>();
		vets.add(Vet.builder().build());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testListVets() throws Exception {

		when(service.findAll()).thenReturn(vets);
		mockMvc.perform(get("/vets")).andExpect(status().isOk()).andExpect(view().name("vets/index"))
				.andExpect(model().attributeExists("vets"));
	}

}
