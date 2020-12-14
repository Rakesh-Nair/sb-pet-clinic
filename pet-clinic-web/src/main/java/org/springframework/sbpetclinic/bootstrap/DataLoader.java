/**
 * 
 */
package org.springframework.sbpetclinic.bootstrap;

import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.model.Pet;
import org.springframework.sbpetclinic.model.PetType;
import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.service.OwnerService;
import org.springframework.sbpetclinic.service.PetTypeService;
import org.springframework.sbpetclinic.service.VetService;
import org.springframework.sbpetclinic.service.map.OwnerServiceMap;
import org.springframework.sbpetclinic.service.map.VetServiceMap;
import org.springframework.stereotype.Component;

/**
 * @author Rakesh.Nair
 *
 */
@Component
public class DataLoader implements CommandLineRunner {

	public final OwnerService ownerService;
	public final VetService vetService;
	public final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Sanji");
		owner1.setLastName("Vinsmoke");
		owner1.setAddress("202 Ramleela");
		owner1.setCity("Kalyan");
		owner1.setTelephone("9388492232");
		Pet sanjiPet = new Pet();
		sanjiPet.setPetType(savedDogPetType);
		sanjiPet.setOwner(owner1);
		sanjiPet.setBirthDate(LocalDate.now());
		sanjiPet.setName("Yonji");
		owner1.getPets().add(sanjiPet);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Roronoa");
		owner2.setLastName("Zoro");
		owner2.setAddress("203 Ramleela");
		owner2.setCity("Kalyan");
		owner2.setTelephone("9388379224 ");
		Pet zoroPet = new Pet();
		zoroPet.setPetType(savedCatPetType);
		zoroPet.setOwner(owner2);
		zoroPet.setBirthDate(LocalDate.now());
		zoroPet.setName("Niji");
		owner2.getPets().add(zoroPet);
		ownerService.save(owner2);

		Vet vet1 = new Vet();
		vet1.setFirstName("Tony Tony");
		vet1.setLastName("Chopper");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Reiju");
		vet2.setLastName("Vinsmoke");

		vetService.save(vet2);

	}

}
