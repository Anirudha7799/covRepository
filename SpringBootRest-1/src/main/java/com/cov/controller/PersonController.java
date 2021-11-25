package com.cov.controller;

import java.util.List;
import java.util.concurrent.CompletionService;

import javax.management.InvalidAttributeValueException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cov.beans.Person;
import com.cov.exception.InvalidPersonIdException;
import com.cov.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	static Logger logger = Logger.getLogger(PersonController.class);

	@Autowired
	PersonService personservice;

	@GetMapping(value = "/{id}")
	public Person find(@PathVariable int id) throws InvalidPersonIdException, InvalidAttributeValueException {
		logger.info("finding a person with id : " + id);
		Person person = personservice.findById(id);
		logger.info("Found person is " + id + " " + person.getFirstName() + " " + person.getLastName());
		return person;

	}

	@GetMapping()
	public List<Person> findAll() {
		return personservice.findAll();
	}

	@PostMapping
	public Person save(@RequestBody Person person) {
		return personservice.save(person);
	}

	@DeleteMapping(value = "/{id}")
	public Person delete(@PathVariable int id) throws InvalidPersonIdException {
		return personservice.delete(id);
	}

	@PutMapping
	public Person update(@RequestBody Person person) throws InvalidPersonIdException {
		return personservice.update(person);
	}
}