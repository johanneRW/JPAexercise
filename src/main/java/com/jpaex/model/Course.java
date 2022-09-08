package com.jpaex.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @Column
    private String courseName;

    @Column
    private Date startDate;

    public Course() {
    }

    @OneToMany(
            mappedBy = "course_id",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Person> persons=  new ArrayList<Person>();

    public List<Person> getPersons() {
        return persons;}


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

}
