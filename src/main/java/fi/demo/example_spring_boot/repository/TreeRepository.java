package fi.demo.example_spring_boot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fi.demo.example_spring_boot.model.Tree;

@Repository
public interface TreeRepository  extends CrudRepository<Tree, Integer> {

}
