package org.springframework.sbpetclinic.service.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.repositories.VetRepository;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {

	@Mock
	VetRepository repository;

	@InjectMocks
	VetSDJpaService service;

	Vet vet;

	@BeforeEach
	void setUp() throws Exception {
		vet = Vet.builder().id(1L).build();
	}

	@Test
	void testFindAll() {
		Set<Vet> vets = new HashSet<>();
		vets.add(Vet.builder().id(1L).build());
		vets.add(Vet.builder().id(2L).build());
		when(repository.findAll()).thenReturn(vets);
		Set<Vet> returnVets = service.findAll();
		assertNotNull(returnVets);
		assertEquals(2, returnVets.size());
	}

	@Test
	void testFindById() {
		when(repository.findById(anyLong())).thenReturn(Optional.of(vet));
		Vet returnVet = service.findById(1L);
		assertNotNull(returnVet);
		assertEquals(1, returnVet.getId());
	}

	@Test
	void testSave() {
		Vet vetToSave = Vet.builder().id(1L).build();
		when(repository.save(any())).thenReturn(vet);
		Vet returnVet = service.save(vetToSave);
		assertNotNull(returnVet);
		assertEquals(1, returnVet.getId());
	}

	@Test
	void testDelete() {
		service.delete(vet);
		verify(repository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		verify(repository, times(1)).deleteById(anyLong());
	}

}
