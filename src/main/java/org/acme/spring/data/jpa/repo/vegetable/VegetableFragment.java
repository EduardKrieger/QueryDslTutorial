package org.acme.spring.data.jpa.repo.vegetable;

import java.util.List;

import org.acme.spring.data.jpa.model.Fruit;
import org.acme.spring.data.jpa.model.Vegetable;

public interface VegetableFragment {

  public List<Vegetable> findAllQueryDslName(String name);

  public List<Vegetable> findAllQueryDslColor(String name);

  public List<Fruit> findAllQueryDslOrigin(String country);

  public List<Fruit> findAllQueryDslMaxPriceDesc(Float price);
}
