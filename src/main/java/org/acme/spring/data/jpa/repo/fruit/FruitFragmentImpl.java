package org.acme.spring.data.jpa.repo.fruit;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.acme.spring.data.jpa.model.Fruit;
import org.acme.spring.data.jpa.model.Origin;
import org.acme.spring.data.jpa.model.QFruit;
import org.acme.spring.data.jpa.model.QOrigin;

import com.querydsl.jpa.impl.JPAQuery;

public class FruitFragmentImpl implements FruitFragment {

  @Inject
  EntityManager em;

  @Override
  public List<Fruit> findAllQueryDslName(String name) {

    QFruit fruit = QFruit.fruit;
    JPAQuery<Fruit> query = new JPAQuery<Fruit>(this.em);
    query.from(fruit);
    if (name != null && !name.isEmpty()) {
      query.where(fruit.name.eq(name));
    }
    query.orderBy(fruit.name.desc());
    List<Fruit> fruits = query.fetch();
    return fruits;
  }

  @Override
  public List<Fruit> findAllQueryDslColor(String color) {

    QFruit fruit = QFruit.fruit;
    JPAQuery<Fruit> query = new JPAQuery<Fruit>(this.em);
    query.from(fruit);
    if (color != null && !color.isEmpty()) {
      query.where(fruit.color.eq(color));
    }
    return query.orderBy(fruit.color.desc()).fetch();
  }

  @Override
  public List<Fruit> findAllQueryDslOrigin(String country) {

    QOrigin origin = QOrigin.origin;
    JPAQuery<Origin> query = new JPAQuery<Origin>(this.em);
    query.from(origin);
    if (country != null && !country.isEmpty()) {
      query.where(origin.countryName.eq(country));
    }
    return new ArrayList<>(query.fetchOne().getFruits());
  }

  @Override
  public List<Fruit> findAllQueryDslMaxPriceDesc(Float price) {

    QFruit fruit = QFruit.fruit;
    JPAQuery<Fruit> query = new JPAQuery<Fruit>(this.em);
    query.from(fruit);

    if (price != null && price != 0) {
      query.where(fruit.price.loe(price));
    }
    return query.orderBy(fruit.price.desc()).fetch();
  }

  @Override
  public List<Fruit> findAllQueryDslMinPriceAsc(Float price) {

    QFruit fruit = QFruit.fruit;
    JPAQuery<Fruit> query = new JPAQuery<Fruit>(this.em);
    query.from(fruit);

    if (price != null && price != 0) {
      query.where(fruit.price.goe(price));
    }
    return query.orderBy(fruit.price.asc()).fetch();
  }

  @Override
  public List<Fruit> findAllQueryDslColorCountry(String country, String color) {

    QOrigin origin = QOrigin.origin;
    QFruit fruit = QFruit.fruit;
    JPAQuery<Fruit> query = new JPAQuery<>(this.em);
    // JPAQuery<Origin> query = new JPAQuery<>(this.em);
    // query.from(origin);
    query.from(fruit);

    if (color != null && !color.isEmpty()) {
      // query.leftJoin(origin.fruits, fruit).on(fruit.origin.eq(origin)).where(origin.countryName.eq(country));
      query.where(fruit.color.eq(color).and(fruit.origin.countryName.eq(country)));
    }
    return new ArrayList<>(query.fetch());// One().getFruits());
  }

  @Override
  public List<Fruit> findAllQueryDslPriceRange(Float min, Float max) {

    QFruit fruit = QFruit.fruit;
    JPAQuery<Fruit> query = new JPAQuery<Fruit>(this.em);
    query.from(fruit);

    if (min != null && min != 0 && max != null && max != 0) {
      // query.where(fruit.price.goe(min).and(fruit.price.loe(max)));
      query.where(fruit.price.between(min, max));
    }
    return query.orderBy(fruit.price.desc()).fetch();
  }

}
