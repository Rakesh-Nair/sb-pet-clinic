package org.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.sbpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
