package com.clodaldo.souza.crud.endpoint.service;

import com.clodaldo.souza.crud.endpoint.model.Person;

import java.util.List;

public interface PersonService {
    long addUser(Person person);

    void delete(long id);

    Person findById(long id);

    Person findByName(String name);

    List<Person> listAll();

    List<Person> orderName();

}
