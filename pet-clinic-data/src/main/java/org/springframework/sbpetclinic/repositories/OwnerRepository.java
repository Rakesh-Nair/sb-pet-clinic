package org.springframework.sbpetclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.sbpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	public Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String anyString);
}
