package org.acme.spring.data.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FRUIT")
@SuppressWarnings("javadoc")
public class Fruit {

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "COLOR")
  private String color;

  @Column(name = "ORIGIN")
  private String origin;

  @Column(name = "PRICE")
  private Float price;

  public Fruit() {

  }

  public Fruit(String name, String color, String origin, Float price) {

    this.name = name;
    this.color = color;
    this.origin = origin;
    this.price = price;

  }

  public Long getId() {

    return this.id;
  }

  public void setId(Long id) {

    this.id = id;
  }

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getColor() {

    return this.color;
  }

  public void setColor(String color) {

    this.color = color;
  }

  public String getOrigin() {

    return this.origin;
  }

  public void setOrigin(String origin) {

    this.origin = origin;
  }

  public Float getPrice() {

    return this.price;
  }

  public void setPrice(Float price) {

    this.price = price;
  }

}
