package org.springframework.sbpetclinic.controllers;

import java.util.Set;

import org.springframework.sbpetclinic.model.Vet;
import org.springframework.sbpetclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VetController {
	public VetService vetService;

	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({ "/vets", "/vets/index", "/vets/index.html", "/vets.html" })
	public String listVets(Model model) {
		model.addAttribute("vets", this.vetService.findAll());
		return "vets/index";
	}

	@GetMapping("/api/vets")
	public @ResponseBody Set<Vet> getVetJson() {
		return this.vetService.findAll();
	}
}
