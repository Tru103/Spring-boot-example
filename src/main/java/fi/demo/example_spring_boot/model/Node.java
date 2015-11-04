package fi.demo.example_spring_boot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="node")
public class Node {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false )
	private String name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonBackReference
	private Node parent;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Set<Node> children = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Set<Node> getChildren() {
		return children;
	}

	public void setChildren(Set<Node> children) {
		this.children = children;
	}

	public Node(String name, Node parent, Set<Node> children) {
		super();
		this.name = name;
		this.parent = parent;
		this.children = children;
	}

	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", parent=" + parent + ", children=" + children + "]";
	}
	
	

}
