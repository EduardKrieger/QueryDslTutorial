package org.acme.spring.data.jpa.repo.vegetable;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.acme.spring.data.jpa.model.Vegetable;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@SuppressWarnings("javadoc")
@Path("/vegetables")
public class VegetableResource {
  private final VegetableRepository vegetableRepository;

  public VegetableResource(VegetableRepository vegetableRepository) {

    this.vegetableRepository = vegetableRepository;
  }

  @GET
  @Produces("application/json")
  public Iterable<Vegetable> findAll() {

    return this.vegetableRepository.findAll();
  }

  @DELETE
  @Path("{id}")
  public void delete(@PathParam long id) {

    this.vegetableRepository.deleteById(id);
  }

  @POST
  @Path("/name/{name}/color/{color}")
  @Produces("application/json")
  public Vegetable create(@PathParam String name, @PathParam String color, @PathParam String origin,
      @PathParam Float price) {

    return this.vegetableRepository.save(new Vegetable(name, color, origin, price));
  }

  @PUT
  @Path("/id/{id}/color/{color}")
  @Produces("application/json")
  public Vegetable changeColor(@PathParam Long id, @PathParam String color) {

    Optional<Vegetable> optional = this.vegetableRepository.findById(id);
    if (optional.isPresent()) {
      Vegetable vegetable = optional.get();
      vegetable.setColor(color);
      return this.vegetableRepository.save(vegetable);
    }

    throw new IllegalArgumentException("No Vegetable with id " + id + " exists");
  }

  @GET
  @Path("/color/{color}")
  @Produces("application/json")
  public List<Vegetable> findByColor(@PathParam String color) {

    return this.vegetableRepository.findByColor(color);
  }

  @GET
  @Path("/Test/{param}")
  @Produces("application/json")
  public List<Vegetable> test(@PathParam String param) {

    List<Vegetable> meineGemuese = this.vegetableRepository.findAllQueryDslColor(param);
    System.out.println(meineGemuese.size());
    for (Vegetable gemuese : meineGemuese) {
      System.out.println(gemuese.getName());
    }
    System.out.println("Hallo");
    // meineFruechte.stream().map(Vegetable::getName).collect(Collectors.toList());
    return meineGemuese;

  }

}
