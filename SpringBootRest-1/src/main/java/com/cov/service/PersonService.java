package com.cov.service;

import java.util.List;
import java.util.Optional;

import javax.management.InvalidAttributeValueException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cov.beans.Person;
import com.cov.exception.InvalidPersonIdException;
import com.cov.repository.IPersonRepository;

@Service
public class PersonService {
	Logger logger = Logger.getLogger(PersonService.class);
	@Autowired
	IPersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findById(int id) throws InvalidAttributeValueException, InvalidPersonIdException {
		logger.info("finding person with id: " + id);
		Optional<Person> personOptional = personRepository.findById(id);
		InvalidPersonIdException invalidPersonIdException = new InvalidPersonIdException("Person id not found");
		logger.warn(invalidPersonIdException);
		if (!personOptional.isPresent()) {
			throw new InvalidPersonIdException();
		}
		
		Person person = personOptional.get();
		logger.info("person found with id " + id + "is" + person.getFirstName() + " " + person.getLastName());
		return personOptional.get();
	}

	public Person save(Person person) {
		return personRepository.save(person);
	}

	public Person update(Person person) throws InvalidPersonIdException {
		Optional<Person> personOptional = personRepository.findById(person.getId());
		if (!personOptional.isPresent()) {
			throw new InvalidPersonIdException();
		}
		return personRepository.save(person);
	}

	public Person delete(int id) throws InvalidPersonIdException {
		Optional<Person> personOptional = personRepository.findById(id);
		if (!personOptional.isPresent()) {
			throw new InvalidPersonIdException();
		}
		Person person = personOptional.get();
		personRepository.deleteById(id);
		return person;
	}
}