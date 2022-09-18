package com.jpaex.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    private Course course;

    @JsonManagedReference
    public Long getCourseId() {
        if (this.course != null) {
            return course.getCourseId();
        } else {
            return null;
        }
    }

    @JsonManagedReference
    public String getCourseName() {
        if (this.course != null) {
            return course.getCourseName();
        } else {
            return null;
        }
    }

    public Person() {
    }

}

