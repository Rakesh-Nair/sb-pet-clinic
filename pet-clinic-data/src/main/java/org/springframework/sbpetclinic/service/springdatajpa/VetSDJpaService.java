package org.springframework.sbpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.repositories.VetRepository;
import org.springframework.sbpetclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;

	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet t) {
		return vetRepository.save(t);
	}

	@Override
	public void delete(Vet t) {
		vetRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
	}

}
