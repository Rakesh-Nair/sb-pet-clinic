package org.springframework.sbpetclinic.controllers;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.service.OwnerService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController controller;

	MockMvc mockMvc;

	Set<Owner> owners;

	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<>();
		owners.add(Owner.builder().id(1L).build());
		owners.add(Owner.builder().id(2L).build());

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("owners/findOwners"))
				.andExpect(model().attributeExists("owner"));
		verifyZeroInteractions(ownerService);
	}

	@Test
	void testShowOwner() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(get("/owners/123")).andExpect(status().isOk()).andExpect(view().name("owners/ownerDetails"))
				.andExpect(model().attribute("owner", hasProperty("id", is(1L))));
	}

	@Test
	void processFindFormReturnMany() throws Exception {
		List<Owner> list = new ArrayList<>();
		list.add(Owner.builder().id(1L).build());
		list.add(Owner.builder().id(2L).build());
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(list);

		mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("owners/ownersList"))
				.andExpect(model().attribute("selections", hasSize(2)));
	}

	@Test
	void processFindFormReturnOne() throws Exception {
		List<Owner> list = new ArrayList<>();
		list.add(Owner.builder().id(1L).build());
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(list);

		mockMvc.perform(get("/owners")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/1"));
	}

	@Test
	void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/owners/new")).andExpect(status().isOk())
				.andExpect(view().name("owners/createOrUpdateOwnerForm")).andExpect(model().attributeExists("owner"));

		verifyZeroInteractions(ownerService);
	}

	@Test
	void testProcessCreationForm() throws Exception {
		when(ownerService.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(post("/owners/new")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/1")).andExpect(model().attributeExists("owner"));

		verify(ownerService).save(ArgumentMatchers.any());
	}

	@Test
	void testInitUpdateOwnerForm() throws Exception {
		when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(get("/owners/1/edit")).andExpect(status().isOk())
				.andExpect(view().name("owners/createOrUpdateOwnerForm"));

		// verifyZeroInteractions(ownerService);
	}

	@Test
	void testProcesUpdateOwnerForm() throws Exception {
		when(ownerService.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1L).build());

		mockMvc.perform(post("/owners/1/edit")).andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/1")).andExpect(model().attributeExists("owner"));

		verify(ownerService).save(ArgumentMatchers.any());
	}
}
