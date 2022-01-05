package org.acme.spring.data.jpa.repo.fruit;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.acme.spring.data.jpa.model.Fruit;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/fruits")
public class FruitResource {

  private final FruitRepository fruitRepository;

  public FruitResource(FruitRepository fruitRepository) {

    this.fruitRepository = fruitRepository;
  }

  @GET
  @Produces("application/json")
  public Iterable<Fruit> findAll() {

    return this.fruitRepository.findAll();
  }

  @DELETE
  @Path("{id}")
  public void delete(@PathParam long id) {

    this.fruitRepository.deleteById(id);
  }

  @POST
  @Path("/name/{name}/color/{color}/origin/{origin}/price/{price}")
  @Produces("application/json")
  public Fruit create(@PathParam String name, @PathParam String color, @PathParam String origin,
      @PathParam Float price) {

    return this.fruitRepository.save(new Fruit(name, color, origin, price));
  }

  @PUT
  @Path("/id/{id}/color/{color}")
  @Produces("application/json")
  public Fruit changeColor(@PathParam Long id, @PathParam String color) {

    Optional<Fruit> optional = this.fruitRepository.findById(id);
    if (optional.isPresent()) {
      Fruit fruit = optional.get();
      fruit.setColor(color);
      return this.fruitRepository.save(fruit);
    }

    throw new IllegalArgumentException("No Fruit with id " + id + " exists");
  }

  @GET
  @Path("/color/{color}")
  @Produces("application/json")
  public List<Fruit> findByColor(@PathParam String color) {

    return this.fruitRepository.findByColor(color);
  }

  @GET
  @Path("origin/{origin}")
  @Produces("application/json")
  public List<Fruit> findByOrigin(@PathParam String origin) {

    return this.fruitRepository.findAllQueryDslOrigin(origin);

  }

  @GET
  @Path("maxPrice/{price}")
  @Produces("application/json")
  public List<Fruit> findByMaxPriceDesc(@PathParam Float price) {

    return this.fruitRepository.findAllQueryDslMaxPriceDesc(price);
  }

  @GET
  @Path("minPrice/{price}")
  @Produces("application/json")
  public List<Fruit> findByMinPriceAsc(@PathParam Float price) {

    return this.fruitRepository.findAllQueryDslMinPriceAsc(price);
  }

  @GET
  @Path("/color/{color}/country/{country}")
  @Produces("application/json")
  public List<Fruit> findByMaxColorCountry(@PathParam String country, @PathParam String color) {

    return this.fruitRepository.findAllQueryDslColorCountry(country, color);
  }

  @GET
  @Path("/priceMin/{min}/priceMax{max}")
  @Produces("application/json")
  public List<Fruit> findByPriceRange(@PathParam Float min, @PathParam Float max) {

    return this.fruitRepository.findAllQueryDslPriceRange(min, max);
  }


  @GET
  @Path("/name/{name}")
  @Produces("application/json")
  public List<Fruit> findByName(@PathParam String name){

     return null;
  }

}
