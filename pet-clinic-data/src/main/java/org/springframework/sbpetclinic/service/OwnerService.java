package org.springframework.sbpetclinic.service;

import java.util.Set;

import org.springframework.sbpetclinic.model.Owner;

public interface OwnerService {
	Owner findById(Long id);
	Owner save(Owner owner);
	Set<Owner> findAll();
	Owner findByLastName(String lastName);
}
