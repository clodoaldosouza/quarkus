package com.clodaldo.souza.crud.endpoint.rest;

import com.clodaldo.souza.crud.endpoint.model.Person;
import com.clodaldo.souza.crud.endpoint.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService personService;

    @PUT
    @Path("add/{user}/{age}")
    public Person addUser(@PathParam("user") String user, @PathParam("age") int age) {
        Person person = new Person(user, age);
        long id = personService.addUser(person);
        return findById(id);
    }

    @GET
    @Path("find/{id}")
    public Person findById(@PathParam("id") long id) {
        return personService.findById(id);
    }

    @GET
    @Path("findName/{name}")
    public Object findById(@PathParam("name") String name) {
        Person person = personService.findByName(name);
        if (person == null) {
            return Response.created(URI.create("http://localhost:8080/")).build();
        }
        return personService.findByName(name);
    }

    @GET
    public List<Person> listAll() {
        return personService.listAll();
    }

    @GET
    @Path("name")
    public List<Person> orderName() {
        return personService.orderName();
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteUser(@PathParam("id") long id) {
        Person personToDelete = personService.findById(id);
        if (personToDelete == null) {
            Response.created(URI.create("http://localhost:8080/")).build();
        }
        personService.delete(id);
    }

}
