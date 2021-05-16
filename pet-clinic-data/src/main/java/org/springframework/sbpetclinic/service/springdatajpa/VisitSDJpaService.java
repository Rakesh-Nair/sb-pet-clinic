package org.springframework.sbpetclinic.service.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.Visit;
import org.springframework.sbpetclinic.repositories.VisitRepository;
import org.springframework.sbpetclinic.service.VisitService;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

	private final VisitRepository visitRepository;

	public VisitSDJpaService(VisitRepository visitRepository) {
		super();
		this.visitRepository = visitRepository;
	}

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll().forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long id) {
		return visitRepository.findById(id).orElse(null);
	}

	@Override
	public Visit save(Visit t) {
		return visitRepository.save(t);
	}

	@Override
	public void delete(Visit t) {
		visitRepository.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		visitRepository.deleteById(id);
	}

}
