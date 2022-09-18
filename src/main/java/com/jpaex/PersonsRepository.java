package com.jpaex;

import com.jpaex.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends JpaRepository<Person, Long> {
}
