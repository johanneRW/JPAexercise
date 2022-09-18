package com.jpaex.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseName;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date startDate;


    @OneToMany(mappedBy = "course")
    private Set<Person> persons = new HashSet<>();

    public Course() {
    }
}
