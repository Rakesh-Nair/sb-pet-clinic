package org.springframework.sbpetclinic.service.map;

import java.util.Set;

import org.springframework.sbpetclinic.model.Pet;
import org.springframework.sbpetclinic.service.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet t) {
		return super.save(t.getId(),t);
	}
	
	@Override
	public Set<Pet> findAll(){
		return super.findAll();
	}
	
	@Override
	public void delete(Pet t){
		super.delete(t);;
	}
	@Override
	public void deleteById(Long id){
		 super.deleteById(id);
	}
	
	
	

}
