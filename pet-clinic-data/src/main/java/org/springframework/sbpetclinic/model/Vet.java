package org.springframework.sbpetclinic.model;

import java.util.Set;

public class Vet extends Person {
	private Set<Speciality> specialities;

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
