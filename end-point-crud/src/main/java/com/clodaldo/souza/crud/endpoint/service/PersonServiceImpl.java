package com.clodaldo.souza.crud.endpoint.service;

import com.clodaldo.souza.crud.endpoint.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public long addUser(Person person) {
        em.persist(person);
        return person.getId();
    }

    @Transactional
    @Override
    public void delete(long id) {
        Person personToDelete = findById(id);
        em.remove(personToDelete);
        Response.created(URI.create("http://localhost:8080/")).build();
    }

    @Override
    public Person findById(long id) {
        return em.find(Person.class, id);
    }

    @Override
    public Person findByName(String name) {
        return (Person) em.createQuery("select p from Person p where p.name = :name")
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Person> listAll() {
        return em.createQuery("select p from Person p order by p.id", Person.class).getResultList();
    }

    @Override
    public List<Person> orderName() {
        return em.createQuery("select p from Person p order by p.name", Person.class).getResultList();
    }


}
