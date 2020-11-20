package org.springframework.sbpetclinic.service.map;

import java.util.Set;

import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.service.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

	@Override
	public Owner save(Owner t) {
		return super.save(t.getId(),t);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	Owner save(Long id, Owner t) {
		return super.save(id, t);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner t) {
		super.delete(t);
	}

	

}
