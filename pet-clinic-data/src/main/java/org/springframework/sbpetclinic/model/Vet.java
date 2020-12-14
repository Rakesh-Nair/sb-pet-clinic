package org.springframework.sbpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
	private Set<Speciality> specialities = new HashSet<Speciality>();

	/**
	 * @return the specialities
	 */
	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	/**
	 * @param specialities the specialities to set
	 */
	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	
	
}
