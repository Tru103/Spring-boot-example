package fi.demo.example_spring_boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.demo.example_spring_boot.model.Person;

/**
 * 
 * Custom repository where you are able to create your own
 * Queries to database. Extends CrudRepository in order use basic
 * CRUD queries.
 *
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}