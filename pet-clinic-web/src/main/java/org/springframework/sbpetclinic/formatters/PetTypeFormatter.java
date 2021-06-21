package org.springframework.sbpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.sbpetclinic.model.PetType;
import org.springframework.sbpetclinic.service.PetTypeService;
import org.springframework.stereotype.Component;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

	private final PetTypeService petTypeService;

	public PetTypeFormatter(PetTypeService petTypeService) {
		super();
		this.petTypeService = petTypeService;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {
		Collection<PetType> findPetTypes = petTypeService.findAll();

		for (PetType type : findPetTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}

		throw new ParseException("type not found: " + text, 0);
	}

}
