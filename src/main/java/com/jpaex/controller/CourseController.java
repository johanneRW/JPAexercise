package com.jpaex.controller;

import com.jpaex.model.Course;
import com.jpaex.model.Person;
import com.jpaex.services.CourseServices;
import com.jpaex.services.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;


    @RestController
    public class CourseController  {

        private CourseServices courseServices;

        public CourseController(CourseServices courseServices) {
            this.courseServices = courseServices;
        }

        @GetMapping("/allCourses")
        public ResponseEntity<Set<Course>> getAllCourses() {
            return new ResponseEntity<>(courseServices.findAll(), HttpStatus.OK);
        }

        @PostMapping("/addCourse")
        public ResponseEntity<Set<Course>> addCourse(Course course) {
            courseServices.save(course);
            return new ResponseEntity<>(courseServices.findAll(), HttpStatus.OK);
        }

        @GetMapping("/getParticipants")
        public ResponseEntity<Set<Person>> getPersons(Long id) {
            Optional<Course> course_ = courseServices.findById(id);
            if (course_.isPresent()) {
                Course course = course_.get();
                return new ResponseEntity<>(course.getPersons(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
    }


