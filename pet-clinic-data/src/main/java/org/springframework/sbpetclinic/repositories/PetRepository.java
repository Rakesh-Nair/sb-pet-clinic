package org.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.sbpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
