package org.springframework.sbpetclinic.service.map;

import java.util.Set;

import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.service.VetService;
import org.springframework.stereotype.Service;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet t) {
		return super.save(t);
	}
	
	@Override
	public Set<Vet> findAll(){
		return super.findAll();
	}
	
	@Override
	public void delete(Vet t){
		super.delete(t);;
	}
	@Override
	public void deleteById(Long id){
		 super.deleteById(id);
	}
	
	
	

}
