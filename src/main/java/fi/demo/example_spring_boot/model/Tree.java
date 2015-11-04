package fi.demo.example_spring_boot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tree")
public class Tree {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false )
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Set<Node> nodes = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	

	public Tree(String name, Set<Node> nodes) {
		super();
		this.name = name;
		this.nodes = nodes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Tree [id=" + id + ", " + (nodes != null ? "nodes=" + nodes : "") + "]";
	}
	

}
