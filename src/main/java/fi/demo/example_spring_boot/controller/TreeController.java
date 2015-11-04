package fi.demo.example_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.demo.example_spring_boot.model.Node;
import fi.demo.example_spring_boot.model.Tree;
import fi.demo.example_spring_boot.repository.TreeRepository;

@RestController
@RequestMapping("/tree")
public class TreeController {

	@Autowired
	private TreeRepository repository;

	// Data got from DB
	@RequestMapping("/repository/all")
	public Iterable<Tree> allPersons() {
		return repository.findAll();
	}

	@RequestMapping("/repository/add")
	public void addStuff() {
		Tree tree = new Tree();
		tree.setName("Test tree");
		Node rootnode = new Node();
		rootnode.setName("root");
		rootnode.setParent(null);

		for (int i = 0; i < 10; i++) {
			Node node = new Node();
			node.setParent(rootnode);
			node.setName("Times " + i);
			rootnode.getChildren().add(node);
			for (int j = 0; j < 3; j++) {
				Node childNode = new Node();
				childNode.setParent(node);
				childNode.setName("Child times " + i);
				node.getChildren().add(childNode);
				for (int k = 0; k < 2; k++) {
					Node grandChild = new Node();
					grandChild.setParent(node);
					grandChild.setName("Child times " + k);
					childNode.getChildren().add(grandChild);
				}
			}
		}
		tree.getNodes().add(rootnode);

		repository.save(tree);
	}

}
