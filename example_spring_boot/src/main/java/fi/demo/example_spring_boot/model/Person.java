package fi.demo.example_spring_boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Simple bean object with couple attributes.
 * Also note that use persistence to Hibernate can make table
 *
 */
@Entity
@Table(name="person")
public class Person {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false )
	private String name;
	
	@Column(nullable = false )
	private int age;
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
