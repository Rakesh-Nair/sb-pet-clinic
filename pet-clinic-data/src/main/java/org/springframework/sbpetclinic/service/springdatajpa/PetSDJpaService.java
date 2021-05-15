package org.springframework.sbpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.Pet;
import org.springframework.sbpetclinic.repositories.PetRepository;
import org.springframework.sbpetclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {

	private final PetRepository petRepository;

	public PetSDJpaService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet t) {
		return petRepository.save(t);
	}

	@Override
	public void delete(Pet t) {
		petRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
	}

}
