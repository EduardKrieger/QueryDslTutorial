package org.acme.spring.data.jpa.repo.vegetable;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.acme.spring.data.jpa.model.Fruit;
import org.acme.spring.data.jpa.model.Origin;
import org.acme.spring.data.jpa.model.QOrigin;
import org.acme.spring.data.jpa.model.QVegetable;
import org.acme.spring.data.jpa.model.Vegetable;

import com.querydsl.jpa.impl.JPAQuery;

public class VegetableFragmentImpl implements VegetableFragment {

  @Inject
  EntityManager em;

  @Override
  public List<Vegetable> findAllQueryDslName(String name) {

    QVegetable vegetable = QVegetable.vegetable;
    JPAQuery<Vegetable> query = new JPAQuery<Vegetable>(this.em);
    query.from(vegetable);
    if (name != null && !name.isEmpty()) {
      query.where(vegetable.name.eq(name));
    }
    query.orderBy(vegetable.name.desc());
    List<Vegetable> vegetables = query.fetch();
    return vegetables;
  }

  @Override
  public List<Vegetable> findAllQueryDslColor(String name) {

    QVegetable vegetable = QVegetable.vegetable;
    JPAQuery<Vegetable> query = new JPAQuery<Vegetable>(this.em);
    query.from(vegetable);
    if (name != null && !name.isEmpty()) {
      query.where(vegetable.name.eq(name));
    }
    query.orderBy(vegetable.name.desc());
    List<Vegetable> vegetables = query.fetch();
    return vegetables;
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
    // TODO Auto-generated method stub
  }

  @Override
  public List<Fruit> findAllQueryDslMaxPriceDesc(Float price) {

    // TODO Auto-generated method stub
    return null;
  }

}
