package com.jpaex;

import com.jpaex.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonsRepository extends CrudRepository<Person, Long> {
}
