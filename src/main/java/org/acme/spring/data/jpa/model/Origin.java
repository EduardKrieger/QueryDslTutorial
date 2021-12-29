package org.acme.spring.data.jpa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("javadoc")
@Entity
public class Origin {

  @Id
  @GeneratedValue // (strategy = GenerationType.TABLE)
  @Column(name = "ID")
  private Long id;

  @Column(name = "COUNTRY_NAME", unique = true)
  private String countryName;

  @JsonManagedReference
  @OneToMany(mappedBy = "origin", orphanRemoval = true, cascade = CascadeType.ALL)
  private Set<Fruit> fruits;

  public Origin() {

  }

  public Origin(String name) {

    this.countryName = name;
  }

  public Long getId() {

    return this.id;
  }

  public void setId(Long id) {

    this.id = id;
  }

  public String getCountryName() {

    return this.countryName;
  }

  public void setCountryName(String name) {

    this.countryName = name;
  }

  public Set<Fruit> getFruits() {

    return this.fruits;
  }

}
