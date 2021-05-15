package org.springframework.sbpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.PetType;
import org.springframework.sbpetclinic.repositories.PetTypeRepository;
import org.springframework.sbpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;

	public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType t) {
		return petTypeRepository.save(t);
	}

	@Override
	public void delete(PetType t) {
		petTypeRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
	}

}
