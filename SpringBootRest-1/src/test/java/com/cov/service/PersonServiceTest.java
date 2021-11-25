package com.cov.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cov.beans.Person;
import com.cov.repository.IPersonRepository;

@TestInstance(Lifecycle.PER_CLASS)
class IPersonServiceTest {

	@InjectMocks
	PersonService personService;

	@Mock
	IPersonRepository personRepo;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);

		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Anirudha", "Panda"));
		persons.add(new Person(2, "Sonalika", "Samal"));
		persons.add(new Person(3, "Aniket", "Panda"));
		persons.add(new Person(4, "Arati", "Panda"));

		when(personRepo.findAll()).thenReturn(persons);
		when(personRepo.findById(2)).thenReturn(Optional.of(persons.get(1)));
	}

	@Test
	void testFindById() {
//testing
		Optional<Person> person = personRepo.findById(2);
		assertNotNull(person);
		assertSame(person.get().getFirstName(), "Sonalika");
		assertEquals(person.get().getId(), 2);
	}

	@Test
	void testFindAll() {
//Testing
		List<Person> persons = personService.findAll();
		assertNotNull(persons);
		assertEquals(4, persons.size());
	}

	/*
	 * @Test void testSavePerson() { fail("Not yet implemented"); }
	 *
	 *
	 *
	 * @Test void testDeletePerson() { fail("Not yet implemented"); }
	 *
	 *
	 *
	 * @Test void testEditPerson() { fail("Not yet implemented"); }
	 */
}