package org.springframework.sbpetclinic.service.map;

import java.util.Set;

import org.springframework.sbpetclinic.model.Visit;
import org.springframework.sbpetclinic.service.VisitService;

public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit t) {
		if (t.getPet() == null || t.getPet().getOwner() == null || t.getPet().getId() == null
				|| t.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(t);
	}

	@Override
	public void delete(Visit t) {
		super.delete(t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
