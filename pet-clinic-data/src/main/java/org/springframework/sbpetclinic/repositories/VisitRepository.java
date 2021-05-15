package org.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.sbpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
