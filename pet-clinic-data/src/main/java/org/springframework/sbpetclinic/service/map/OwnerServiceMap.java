package org.springframework.sbpetclinic.service.map;

import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.model.Pet;
import org.springframework.sbpetclinic.service.OwnerService;
import org.springframework.sbpetclinic.service.PetService;
import org.springframework.sbpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
@Profile({ "default", "map" })
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner t) {
		if (t != null) {
			if (t.getPets() != null) {
				t.getPets().forEach(p -> {
					if (p.getPetType() != null) {
						if (p.getPetType().getId() == null) {
							p.setPetType(petTypeService.save(p.getPetType()));
						}
					} else {
						throw new RuntimeException("Pet Type is Required");
					}

					if (p.getId() == null) {
						Pet savedPet = petService.save(p);
						p.setId(savedPet.getId());
					}
				});
			}
			return super.save(t);
		} else {
			return null;
		}

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
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner t) {
		super.delete(t);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll().stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName)).findFirst()
				.orElse(null);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String anyString) {
		// TODO Auto-generated method stub
		return null;
	}
}
