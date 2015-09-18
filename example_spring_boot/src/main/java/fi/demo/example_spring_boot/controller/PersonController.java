package fi.demo.example_spring_boot.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.demo.example_spring_boot.model.Person;
import fi.demo.example_spring_boot.repository.PersonRepository;
import fi.demo.example_spring_boot.service.PersonService;

/**
 * 
 * Restcontroller which helps creating REST-calls
 * Use two services, first one is for static reference
 * {@link PersonRepository} is more JPA like, it actually access db
 *
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@Autowired
	private PersonRepository PersonRepository;
	
	//This is static
	@RequestMapping("/all")
	public Hashtable<String, Person> getAll(){
		return personService.getAll();
	}
	
	//This is static
	@RequestMapping("{id}")
	public Person getPerson(@PathVariable("id") String id){
		return personService.getPerson(id);
	}
	
	//Data got from DB
	@RequestMapping("/repository/all")
	public Iterable<Person> allPersons(){
		return PersonRepository.findAll();
	}
	
	//Data got from DB
	@RequestMapping("/repository/{id}")
	public Person getPersonFromDbById(@PathVariable("id") long id){
		return PersonRepository.findOne(id);
	}
	
}