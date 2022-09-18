package com.jpaex.controller;

import com.jpaex.model.Course;
import com.jpaex.model.Person;
import com.jpaex.services.CourseServices;
import com.jpaex.services.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class PersonController {

    private PersonServices personServices;
    private CourseServices courseServices;

    public PersonController(PersonServices personServices, CourseServices courseServices) {
        this.personServices = personServices;
        this.courseServices = courseServices;
    }

    @GetMapping("/allPersons")
    public ResponseEntity<Set<Person>> getAllPersons() {
        return new ResponseEntity<>(personServices.findAll(), HttpStatus.OK);
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestParam Long courseId, Person person) {
        Optional<Course> course_ = courseServices.findById(courseId);
        if (course_.isPresent()) {
            Course course = course_.get();
            person.setCourse(course);
            personServices.save(person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            personServices.save(person);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/deletePerson")
    public ResponseEntity<Set<Person>> deletePerson(Long id) {
        personServices.deleteById(id);
        return new ResponseEntity<>(personServices.findAll(), HttpStatus.OK);
    }

    @PostMapping("/editPerson")
    public ResponseEntity<Person> editPerson(Long id, Person editedPerson, @RequestParam Long courseId) {
        Optional<Person> orgPerson = personServices.findById(id);
        if (orgPerson.isPresent()) {
            Optional<Course> course_ = courseServices.findById(courseId);
            if (course_.isPresent()) {
                Course course = course_.get();
                editedPerson.setCourse(course);
                personServices.save(editedPerson);
                return new ResponseEntity<>(editedPerson, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(editedPerson, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(editedPerson, HttpStatus.NOT_FOUND);
        }

    }
}
