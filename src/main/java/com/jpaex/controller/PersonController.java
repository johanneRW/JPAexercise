package com.jpaex.controller;

import com.jpaex.model.Person;
import com.jpaex.services.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class PersonController {

    private PersonServices persServices;

    public PersonController(PersonServices persServices) {
        this.persServices = persServices;
    }

    @GetMapping("/allPersons")
    public ResponseEntity<Set<Person>> getAllPersons() {
        return new ResponseEntity<>(persServices.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Set<Person>> addPerson(Person person) {
        persServices.save(person);
        return new ResponseEntity<>(persServices.findAll(), HttpStatus.OK);
    }

    @PostMapping("/deletePerson")
    public ResponseEntity<Set<Person>> deletePerson(Long id) {
        persServices.deleteById(id);
        return new ResponseEntity<>(persServices.findAll(), HttpStatus.OK);
    }

    @PostMapping("/editPerson")
    public ResponseEntity<Set<Person>> editPerson(Long id, Person editedPerson) {
        Optional<Person> orgPerson = persServices.findById(id);
        if (orgPerson.isPresent()) {
            persServices.save(editedPerson);
            return new ResponseEntity<>(persServices.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(persServices.findAll(), HttpStatus.NOT_FOUND);
        }

    }
}
