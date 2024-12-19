package ru.bl00dphant0m.population.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bl00dphant0m.population.model.Person;
import ru.bl00dphant0m.population.service.PersonService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping("/{count}")
    public ResponseEntity<String> create(@PathVariable int count) {
        long startTime = System.currentTimeMillis();
        personService.createPersons(count);
        long endTime = System.currentTimeMillis();
        return ResponseEntity.ok("Создано " + count + " пользователей" + " за время " + (endTime - startTime));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Person>> search(@RequestParam String name,
                                               @RequestParam int age) {
        long startTime = System.currentTimeMillis();
        List<Person> personList = personService.getPersonsByNameAndAge(name, age);
        long endTime = System.currentTimeMillis();
        log.info("search by age за время " + (endTime - startTime));
        return ResponseEntity.ok(personList);
    }
}
