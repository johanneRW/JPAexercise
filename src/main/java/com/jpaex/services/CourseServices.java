package com.jpaex.services;

import com.jpaex.CourseRepository;
import com.jpaex.model.Course;
import com.jpaex.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseServices implements ICourseServices{

    private CourseRepository courseRepo;

    public CourseServices(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Set<Course> findAll() {
        Set<Course> set= new HashSet<>();
        courseRepo.findAll().forEach(set::add);
        return set;
    }

    @Override
    public Course save(Course object) {
        Course course = (Course) object;
        return courseRepo.save(course);}

    @Override
    public void delete(Course object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Course> findById(Long aLong) {
            return courseRepo.findById(aLong);
        }

}
