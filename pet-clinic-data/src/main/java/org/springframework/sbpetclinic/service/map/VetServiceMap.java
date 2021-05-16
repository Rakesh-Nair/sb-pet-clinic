package org.springframework.sbpetclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.Speciality;
import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.service.SpecialityService;
import org.springframework.sbpetclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
@Profile({ "default", "map" })
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;

	public VetServiceMap(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet t) {
		if (t.getSpecialities().size() > 0) {
			t.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(t);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(Vet t) {
		super.delete(t);
		;
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
