package org.springframework.sbpetclinic.controllers;

import org.springframework.sbpetclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
	public VetService vetService;
	
	
	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}


	@RequestMapping({"/vets","/vets/index","/vets/index.html"})
	public String listVets(Model model) {
		model.addAttribute("vets", this.vetService.findAll());
		return "vets/index";
	}
}
