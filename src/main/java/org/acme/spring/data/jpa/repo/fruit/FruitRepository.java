package org.acme.spring.data.jpa.repo.fruit;

import java.util.List;

import org.acme.spring.data.jpa.model.Fruit;
import org.springframework.data.repository.CrudRepository;

public interface FruitRepository extends CrudRepository<Fruit, Long> {

  List<Fruit> findByColor(String color);

}
