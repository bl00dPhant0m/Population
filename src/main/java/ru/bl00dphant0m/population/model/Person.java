package ru.bl00dphant0m.population.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "persons", indexes = {
        @Index(name = "idx_name",columnList = "name"),
        @Index(name = "idx_age", columnList = "age")
})
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private double balance;
    private LocalDateTime createdAt;


}
