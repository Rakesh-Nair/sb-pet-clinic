package org.springframework.sbpetclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.Speciality;
import org.springframework.sbpetclinic.service.SpecialityService;
import org.springframework.stereotype.Service;

@Service
@Profile({ "default", "map" })
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

	@Override
	public Set<Speciality> findAll() {

		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {

		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality t) {

		return super.save(t);
	}

	@Override
	public void delete(Speciality t) {
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
