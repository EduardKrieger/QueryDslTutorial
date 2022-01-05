package org.acme.spring.data.jpa.repo.fruit;

import java.util.List;

import org.acme.spring.data.jpa.model.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FruitRepository extends CrudRepository<Fruit, Long> {

  List<Fruit> findByColor(String color);

  // @Query("select a from Fruit where name = :name")
  List<Fruit> findByName(@Param("name") String name);

  List<Fruit> findByOrigin(String origin);

  // List<Fruit> findByMaxPriceDesc(Float price);
}
