package ru.bl00dphant0m.population.service;

import ru.bl00dphant0m.population.model.Person;

import java.util.List;

public interface PersonService {
    void createPersons(int count);
    List<Person> getPersonsByNameAndAge(String name, int age);
}
