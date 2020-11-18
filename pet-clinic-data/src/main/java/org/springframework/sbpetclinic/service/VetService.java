package org.springframework.sbpetclinic.service;

import java.util.Set;

import org.springframework.sbpetclinic.model.Vet;

public interface VetService {
	Vet findById(Long id);
	Vet save(Vet vet);
	Set<Vet> findAll();
}
