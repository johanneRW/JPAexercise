package com.jpaex.controller;

import com.jpaex.model.Course;
import com.jpaex.model.Person;
import com.jpaex.services.CourseServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;


    @RestController
    public class CourseController  {

        private CourseServices courServices;

        public CourseController(CourseServices courServices) {
            this.courServices = courServices;
        }


        @GetMapping("/allCourse")
        public ResponseEntity<Set<Course>> getAllCourses() {
            return new ResponseEntity<>(courServices.findAll(), HttpStatus.OK);
        }

        @PostMapping("/addCourse")
        public ResponseEntity<Set<Course>> addCourse(Course course) {
            courServices.save(course);
            return new ResponseEntity<>(courServices.findAll(), HttpStatus.OK);
        }

        @GetMapping("/getParticipants")
        public ResponseEntity <Set<Person>>getPersons(Long id) {
            Optional<Course> course=courServices.findById(id);
            if (course.isPresent()) {
                Set<Person> participants= course.get().getPersons();
                return new ResponseEntity<>(participants, HttpStatus.OK);
            } else {return new ResponseEntity<>(null,HttpStatus.NOT_FOUND); }
        }}


