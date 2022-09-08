package com.jpaex.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    private String courseName;

    @Column
    private Date startDate;

    public Course() {
    }

    @OneToMany(orphanRemoval=true)
    @JoinColumn(name="course_id")
    private Set<Person> persons;
    public Set<Person> getPersons() {
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

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

}
