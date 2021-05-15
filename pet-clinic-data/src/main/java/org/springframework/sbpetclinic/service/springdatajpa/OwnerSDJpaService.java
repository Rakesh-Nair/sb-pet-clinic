package org.springframework.sbpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.repositories.OwnerRepository;
import org.springframework.sbpetclinic.repositories.PetRepository;
import org.springframework.sbpetclinic.repositories.PetTypeRepository;
import org.springframework.sbpetclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;

	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner t) {
		return ownerRepository.save(t);
	}

	@Override
	public void delete(Owner t) {
		ownerRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
