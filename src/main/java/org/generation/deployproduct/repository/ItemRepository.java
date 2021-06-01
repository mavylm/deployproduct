package org.generation.deployproduct.repository;

import org.generation.deployproduct.repository.Entity.Item;
import org.springframework.data.repository.*;


public interface ItemRepository extends CrudRepository<Item, Integer> {

}
