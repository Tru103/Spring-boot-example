package fi.demo.example_spring_boot.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import fi.demo.example_spring_boot.model.Person;

/**
 * 
 * Static service in order to test rest calls
 *
 */
@Service
public class PersonService {
	
	//PersonHash
	Hashtable<String, Person> personHash = new Hashtable<String, Person>();
	
	//when init, do
	public PersonService(){
		//Create new person
		Person person  = new Person();
		person.setId(1);
		person.setName("Test name");
		person.setAge(22);
		personHash.put("1", person);
		
		//reInit person with different data
		person  = new Person();
		person.setId(2);
		person.setName("Actual Name of One Person");
		person.setAge(65);
		personHash.put("2", person);
	}
	
	//getPerson with id that is found from hash value
	public Person getPerson(String id){
		if(personHash.containsKey(id))
			return personHash.get(id);
		else
			return null;
	}
	

	//When all is requested, return hash
	public Hashtable<String, Person> getAll(){
		return personHash;
	}
	
}