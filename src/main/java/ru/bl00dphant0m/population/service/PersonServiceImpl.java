package ru.bl00dphant0m.population.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bl00dphant0m.population.model.Person;
import ru.bl00dphant0m.population.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service

public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    @Transactional
    public void createPersons(int count) {
        String [] names = {"Dima","Anna","Lena"};

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Person person = new Person();
            person.setAge(random.nextInt(100));
            person.setName(names[random.nextInt(names.length)]);

            person.setBalance(random.nextDouble(3000));
            person.setCreatedAt(LocalDateTime.now().minusDays(random.nextInt(36500)));
            personRepository.save(person);
        }

    }

    @Override
    public List<Person> getPersonsByNameAndAge(String name, int age) {

        return personRepository.findByNameAndAge(name, age);
    }
}
