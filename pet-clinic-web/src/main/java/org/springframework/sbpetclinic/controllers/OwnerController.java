package org.springframework.sbpetclinic.controllers;

import org.springframework.sbpetclinic.model.Owner;
import org.springframework.sbpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class OwnerController {

	public OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@RequestMapping({ "", "/index", "/index.html" })
	public String listOwners(Model model) {
		model.addAttribute("owners", this.ownerService.findAll());
		return "owners/index";
	}

	@RequestMapping("/find")
	public String findOwners() {
		return "notimplemented";
	}

	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		Owner owner = this.ownerService.findById(ownerId);
		mav.addObject(owner);
		return mav;
	}
}
