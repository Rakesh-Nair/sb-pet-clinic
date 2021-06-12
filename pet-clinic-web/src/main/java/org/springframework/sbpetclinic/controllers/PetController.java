package org.springframework.sbpetclinic.controllers;

import java.util.Collection;

import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.model.PetType;
import org.springframework.sbpetclinic.service.OwnerService;
import org.springframework.sbpetclinic.service.PetService;
import org.springframework.sbpetclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

	private final PetService petService;
	private final OwnerService ownerService;
	private final PetTypeService petTypeService;

	public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
	}

	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes() {
		return this.petTypeService.findAll();
	}

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
		return this.ownerService.findById(ownerId);
	}

	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
}
