/**
 * 
 */
package org.springframework.sbpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.model.Pet;
import org.springframework.sbpetclinic.model.PetType;
import org.springframework.sbpetclinic.model.Speciality;
import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.model.Visit;
import org.springframework.sbpetclinic.service.OwnerService;
import org.springframework.sbpetclinic.service.PetTypeService;
import org.springframework.sbpetclinic.service.SpecialityService;
import org.springframework.sbpetclinic.service.VetService;
import org.springframework.sbpetclinic.service.VisitService;
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
	public final SpecialityService specialityService;
	public final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

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

		Visit catVisit = new Visit();
		catVisit.setDate(LocalDate.now());
		catVisit.setPet(zoroPet);
		catVisit.setDescription("Pirate Hunter");
		visitService.save(catVisit);

		Vet vet1 = new Vet();
		vet1.setFirstName("Tony Tony");
		vet1.setLastName("Chopper");
		vet1.getSpecialities().add(savedRadiology);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Reiju");
		vet2.setLastName("Vinsmoke");
		vet2.getSpecialities().add(savedDentistry);
		vetService.save(vet2);
	}

}
