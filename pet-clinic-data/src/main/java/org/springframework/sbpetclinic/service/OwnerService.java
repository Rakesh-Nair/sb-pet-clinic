package org.springframework.sbpetclinic.service;

import java.util.List;

import org.springframework.sbpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String anyString);
}
