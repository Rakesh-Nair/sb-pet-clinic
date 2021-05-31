package org.springframework.sbpetclinic.service.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.sbpetclinic.model.Owner;

class OwnerServiceMapTest {

	OwnerServiceMap ownerServiceMap;
	final Long ownerId = 1L;
	final String lastName = "Vinsmoke";

	@BeforeEach
	void setUp() throws Exception {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testSaveOwner() {
		Long id = 2L;
		Owner savedOwner = ownerServiceMap.save(Owner.builder().id(id).build());
		assertEquals(id, savedOwner.getId());
	}

	@Test
	void testSaveOwnerNoId() {
		Long id = 2L;
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertEquals(id, savedOwner.getId());
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner vinsmoke = ownerServiceMap.findByLastName(lastName);
		assertNotNull(vinsmoke);
		assertEquals(ownerId, vinsmoke.getId());
	}

	@Test
	void testFindByLastNameNotFound() {
		Owner vinsmoke = ownerServiceMap.findByLastName("Monkey");
		assertNull(vinsmoke);
	}

}
