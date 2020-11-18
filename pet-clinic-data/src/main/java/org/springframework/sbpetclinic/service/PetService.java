package org.springframework.sbpetclinic.service;

import java.util.Set;

import org.springframework.sbpetclinic.model.Pet;

public interface PetService {
	Pet findById(Long id);
	Pet save(Pet pet);
	Set<Pet> findAll();
}
