package org.acme.spring.data.jpa.repo.vegetable;

import java.util.List;

import org.acme.spring.data.jpa.model.Vegetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VegetableRepository extends CrudRepository<Vegetable, Long>, VegetableFragment {

  List<Vegetable> findByColor(String color);

  // @Query("select a from Vegetable where name = :name")
  List<Vegetable> findByName(@Param("name") String name);
}
