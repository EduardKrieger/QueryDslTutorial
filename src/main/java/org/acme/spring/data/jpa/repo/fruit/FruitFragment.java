package org.acme.spring.data.jpa.repo.fruit;

import java.util.List;

import org.acme.spring.data.jpa.model.Fruit;

public interface FruitFragment {

  public List<Fruit> findAllQueryDslName(String name);

  public List<Fruit> findAllQueryDslColor(String color);

  public List<Fruit> findAllQueryDslOrigin(String country);

  public List<Fruit> findAllQueryDslMaxPriceDesc(Float price);

  public List<Fruit> findAllQueryDslMinPriceAsc(Float price);

  public List<Fruit> findAllQueryDslColorCountry(String country, String color);

  public List<Fruit> findAllQueryDslPriceRange(Float min, Float max);

}
